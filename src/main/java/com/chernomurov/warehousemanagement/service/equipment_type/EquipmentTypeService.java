package com.chernomurov.warehousemanagement.service.equipment_type;

import com.chernomurov.warehousemanagement.entity.EquipmentType;
import org.springframework.http.RequestEntity;

public interface EquipmentTypeService {
    EquipmentType createEquipmentType(RequestEntity<EquipmentType> name);
    EquipmentType getEquipmentTypeById(Long id);
    int updateEquipmentType(Long id, RequestEntity<EquipmentType> request);
    void deleteEquipmentTypeById(Long id);
}
