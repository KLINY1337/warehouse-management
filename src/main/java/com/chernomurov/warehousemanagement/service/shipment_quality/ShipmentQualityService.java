package com.chernomurov.warehousemanagement.service.shipment_quality;

import com.chernomurov.warehousemanagement.custom.http.request.ShipmentQualityRequest;
import com.chernomurov.warehousemanagement.entity.Equipment;
import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.Shipment;
import com.chernomurov.warehousemanagement.entity.ShipmentQuality;

import java.math.BigDecimal;

public interface ShipmentQualityService {
    ShipmentQuality createShipmentQuality(ShipmentQualityRequest request);
    ShipmentQuality getShipmentQualityByShipment(Shipment shipment);
    ShipmentQuality updateShipmentQuality(Shipment shipment, ShipmentQualityRequest request);
    void deleteShipmentQualityByShipment(Shipment shipment);
}
