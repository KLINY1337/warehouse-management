package com.chernomurov.warehousemanagement.service.equipment_type;

import com.chernomurov.warehousemanagement.entity.EquipmentType;
import com.chernomurov.warehousemanagement.repository.EquipmentTypeRepository;
import com.chernomurov.warehousemanagement.util.ValidationUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EquipmentTypeServiceImpl implements EquipmentTypeService {

    private final EquipmentTypeRepository equipmentTypeRepository;

    @Override
    public EquipmentType createEquipmentType(RequestEntity<EquipmentType> request) {

        List<String> fieldNamesToValidate = new ArrayList<>();
        fieldNamesToValidate.add("name");
        ValidationUtils.validateRequest(request, fieldNamesToValidate);

        EquipmentType equipmentType = EquipmentType.builder()
                .name(request.getBody().getName())
                .build();
        return equipmentTypeRepository.save(equipmentType);
    }



    @Override
    public EquipmentType getEquipmentTypeById(Long id) {
        return equipmentTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Тип снаряжения с id " + id + " не найден, действие отменено."));
    }

    @Override
    public int updateEquipmentType(Long id, RequestEntity<EquipmentType> request) {
        List<String> fieldNamesToValidate = new ArrayList<>();
        fieldNamesToValidate.add("id");
        fieldNamesToValidate.add("name");
        ValidationUtils.validateRequest(request, fieldNamesToValidate);

        EquipmentType requestBody = Objects.requireNonNull(request.getBody());
        return equipmentTypeRepository.updateNameById(requestBody.getName(), requestBody.getId());
    }

    @Override
    public void deleteEquipmentTypeById(Long id) {
        equipmentTypeRepository.deleteById(id);
    }
}
