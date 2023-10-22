package com.chernomurov.warehousemanagement.service.equipment;

import com.chernomurov.warehousemanagement.entity.Equipment;
import com.chernomurov.warehousemanagement.entity.EquipmentType;

import java.util.Set;

public interface EquipmentService {

    void createEquipment(String name, Set<EquipmentType> equipmentTypes);
    Equipment getEquipmentById(Long id);
    void updateEquipment(Long id, String name, Set<EquipmentType> equipmentTypes);
    void deleteEquipmentById(Long id);
}
