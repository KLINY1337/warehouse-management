package com.chernomurov.warehousemanagement.service.shipment;

import com.chernomurov.warehousemanagement.custom.http.request.ShipmentRequest;
import com.chernomurov.warehousemanagement.entity.Equipment;
import com.chernomurov.warehousemanagement.entity.EquipmentType;
import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.Shipment;

import java.util.Set;

public interface ShipmentService {
    Shipment createShipment(ShipmentRequest request);
    Shipment getShipmentById(Long id);
    Shipment updateShipment(Long id, ShipmentRequest request);
    void deleteShipmentById(Long id);
}
