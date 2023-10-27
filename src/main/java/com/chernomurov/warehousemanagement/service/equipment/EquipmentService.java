package com.chernomurov.warehousemanagement.service.equipment;

import com.chernomurov.warehousemanagement.custom.http.request.EquipmentRequest;
import com.chernomurov.warehousemanagement.entity.Equipment;
import com.chernomurov.warehousemanagement.entity.EquipmentType;

import java.util.Set;

public interface EquipmentService {

    Equipment createEquipment(EquipmentRequest request);
    Equipment getEquipmentById(Long id);
    Equipment updateEquipment(Long id, EquipmentRequest request);
    void deleteEquipmentById(Long id);
}
