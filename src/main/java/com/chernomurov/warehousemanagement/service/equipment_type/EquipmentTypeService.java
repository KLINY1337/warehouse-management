package com.chernomurov.warehousemanagement.service.equipment_type;

import com.chernomurov.warehousemanagement.custom.http.request.EquipmentTypeRequest;
import com.chernomurov.warehousemanagement.entity.EquipmentType;

public interface EquipmentTypeService {
    EquipmentType createEquipmentType(EquipmentTypeRequest request);
    EquipmentType getEquipmentTypeById(Long id);
    EquipmentType updateEquipmentType(Long id, EquipmentTypeRequest equipmentType);
    void deleteEquipmentTypeById(Long id);
}
