package com.chernomurov.warehousemanagement.service.shipment_quality;

import com.chernomurov.warehousemanagement.entity.Equipment;
import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.Shipment;
import com.chernomurov.warehousemanagement.entity.ShipmentQuality;

import java.math.BigDecimal;

public interface ShipmentQualityService {
    void createShipmentQuality(Shipment shipment, BigDecimal qualityCoefficient);
    ShipmentQuality getShipmentQualityByShipment(Shipment shipment);
    void updateShipmentQuality(Shipment shipment, BigDecimal qualityCoefficient);
    void deleteShipmentQualityByShipment(Shipment shipment);
}
