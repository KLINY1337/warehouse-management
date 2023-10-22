package com.chernomurov.warehousemanagement.service.shipment;

import com.chernomurov.warehousemanagement.entity.Equipment;
import com.chernomurov.warehousemanagement.entity.EquipmentType;
import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.Shipment;

import java.util.Set;

public interface ShipmentService {
    void createShipment(Product product, Integer amount);
    Shipment getShipmentById(Long id);
    void updateShipment(Long id, Product product, Integer amount);
    void deleteShipmentById(Long id);
}
