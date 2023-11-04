package com.chernomurov.warehousemanagement.controller;

import com.chernomurov.warehousemanagement.custom.http.request.ShipmentQualityRequest;
import com.chernomurov.warehousemanagement.entity.Shipment;
import com.chernomurov.warehousemanagement.entity.ShipmentQuality;
import com.chernomurov.warehousemanagement.service.shipment_quality.ShipmentQualityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/shipment/quality")
public class ShipmentQualityController {

    private final ShipmentQualityService shipmentQualityService;

    @PostMapping("/{shipment:\\d+}")
    public ResponseEntity<ShipmentQuality> createShipmentQuality(@PathVariable("shipment") Shipment shipment, @RequestBody ShipmentQualityRequest request) {
        return ResponseEntity.ok(shipmentQualityService.createShipmentQuality(shipment, request));
    }

    @GetMapping("/{shipment:\\d+}")
    public ResponseEntity<ShipmentQuality> getShipmentQualityByShipment(@PathVariable("shipment") Shipment shipment) {
        return ResponseEntity.ok(shipmentQualityService.getShipmentQualityByShipment(shipment));
    }

    @PutMapping("/{shipment:\\d+}")
    public ResponseEntity<ShipmentQuality> updateShipmentQuality(@PathVariable("shipment") Shipment shipment, @RequestBody ShipmentQualityRequest request) {
        return ResponseEntity.ok(shipmentQualityService.updateShipmentQuality(shipment, request));
    }

    @DeleteMapping("/{shipment:\\d+}")
    public void deleteShipmentQualityByShipment(@PathVariable("shipment") Shipment shipment) {
        shipmentQualityService.deleteShipmentQualityByShipment(shipment);
    }
}
