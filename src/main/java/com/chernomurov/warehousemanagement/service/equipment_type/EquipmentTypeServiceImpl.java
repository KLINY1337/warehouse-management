package com.chernomurov.warehousemanagement.service.equipment_type;

import com.chernomurov.warehousemanagement.custom.http.request.EquipmentTypeRequest;
import com.chernomurov.warehousemanagement.entity.EquipmentType;
import com.chernomurov.warehousemanagement.repository.EquipmentTypeRepository;
import com.chernomurov.warehousemanagement.util.ValidationUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentTypeServiceImpl implements EquipmentTypeService {

    private final EquipmentTypeRepository equipmentTypeRepository;

    @Override
    public EquipmentType createEquipmentType(EquipmentTypeRequest request) {
        EquipmentType equipmentType = getEquipmentTypeFromRequest(null, request);
        return equipmentTypeRepository.save(equipmentType);
    }

    @Override
    public EquipmentType getEquipmentTypeById(Long id) {
        return equipmentTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Тип снаряжения с id " + id + " не найден, действие отменено."));
    }

    @Override
    public EquipmentType updateEquipmentType(Long id, EquipmentTypeRequest request) {
        EquipmentType equipmentType = getEquipmentTypeFromRequest(id, request);

        if (equipmentTypeRepository.existsById(id)){
            return equipmentTypeRepository.save(equipmentType);
        }
        else {
            throw new  EntityNotFoundException("Тип снаряжения с " + id + " не найден, действие отменено.");
        }
    }

    @Override
    public void deleteEquipmentTypeById(Long id) {
        if (equipmentTypeRepository.existsById(id)){
            equipmentTypeRepository.deleteById(id);
        }
        else {
            throw new  EntityNotFoundException("Тип снаряжения с id " + id + " не найден, действие отменено.");
        }
    }

    private static EquipmentType getEquipmentTypeFromRequest(Long id, EquipmentTypeRequest request) {
        List<String> fieldNamesToValidate = new ArrayList<>();
        fieldNamesToValidate.add("name");
        ValidationUtils.validateRequest(request, fieldNamesToValidate);

        return EquipmentType.builder()
                .id(id)
                .name(request.name())
                .build();
    }
}
