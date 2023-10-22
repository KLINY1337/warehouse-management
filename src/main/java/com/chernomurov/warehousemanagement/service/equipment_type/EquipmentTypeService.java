package com.chernomurov.warehousemanagement.service.equipment_type;

import com.chernomurov.warehousemanagement.entity.Equipment;
import com.chernomurov.warehousemanagement.entity.EquipmentType;

import java.util.Set;

public interface EquipmentTypeService {
    void createEquipmentType(String name);
    EquipmentType getEquipmentTypeById(Long id);
    void updateEquipmentType(Long id, String name);
    void deleteEquipmentTypeById(Long id);
}
