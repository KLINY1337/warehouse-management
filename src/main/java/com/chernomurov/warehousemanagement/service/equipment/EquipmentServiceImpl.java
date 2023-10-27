package com.chernomurov.warehousemanagement.service.equipment;

import com.chernomurov.warehousemanagement.custom.http.DTO.EquipmentTypeDto;
import com.chernomurov.warehousemanagement.custom.http.request.EquipmentRequest;
import com.chernomurov.warehousemanagement.entity.Equipment;
import com.chernomurov.warehousemanagement.entity.EquipmentType;
import com.chernomurov.warehousemanagement.repository.EquipmentRepository;
import com.chernomurov.warehousemanagement.repository.EquipmentTypeRepository;
import com.chernomurov.warehousemanagement.util.ValidationUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService{

    private final EquipmentRepository equipmentRepository;
    private final EquipmentTypeRepository equipmentTypeRepository;

    @Override
    public Equipment createEquipment(EquipmentRequest request) {
        Equipment equipment = getEquipmentFromRequest(null, request);
        return equipmentRepository.save(equipment);
    }

    @Override
    public Equipment getEquipmentById(Long id) {
        return equipmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Снаряжение с id " + id + " не найдено, действие отменено."));
    }

    @Override
    public Equipment updateEquipment(Long id, EquipmentRequest request) {

        Equipment equipment = getEquipmentFromRequest(id, request);
        if (equipmentRepository.existsById(id)){
            return equipmentRepository.save(equipment);
        }
        else {
            throw new  EntityNotFoundException("Снаряжение с id " + id + " не найдено, действие отменено.");
        }
    }

    @Override
    public void deleteEquipmentById(Long id) {
        if (equipmentRepository.existsById(id)){
            equipmentRepository.deleteById(id);
        }
        else {
            throw new  EntityNotFoundException("Снаряжение с id " + id + " не найдено, действие отменено.");
        }
    }

    private Equipment getEquipmentFromRequest(Long id, EquipmentRequest request) {
        List<String> fieldNamesToValidate = new ArrayList<>();
        fieldNamesToValidate.add("name");
        fieldNamesToValidate.add("equipmentTypes");
        ValidationUtils.validateRequest(request, fieldNamesToValidate);

        Set<EquipmentType> equipmentTypes = new HashSet<>();
        for (EquipmentTypeDto e : request.equipmentTypes()) {
            EquipmentType equipmentType = equipmentTypeRepository.findById(e.id())
                    .orElseThrow(() -> new EntityNotFoundException("Снаряжение с id " + e.id() + " не найдено, действие отменено."));
            equipmentTypes.add(equipmentType);
        }

        return Equipment.builder()
                .id(id)
                .name(request.name())
                .equipmentTypes(equipmentTypes)
                .build();
    }
}
