package com.chernomurov.warehousemanagement.service.equipment_type;

import com.chernomurov.warehousemanagement.entity.EquipmentType;

public interface EquipmentTypeService {
    EquipmentType createEquipmentType(EquipmentType equipmentType);
    EquipmentType getEquipmentTypeById(Long id);
    EquipmentType updateEquipmentType(Long id, EquipmentType equipmentType);
    void deleteEquipmentTypeById(Long id);
}
