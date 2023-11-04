package com.chernomurov.warehousemanagement.controller;

import com.chernomurov.warehousemanagement.custom.http.request.ShipmentRequest;
import com.chernomurov.warehousemanagement.entity.Shipment;
import com.chernomurov.warehousemanagement.service.shipment.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/shipment")
public class ShipmentController {

    private final ShipmentService shipmentService;

    @PostMapping
    public Shipment createShipment(@RequestBody ShipmentRequest request) {
        return shipmentService.createShipment(request);
    }

    @GetMapping("/{id}")
    public Shipment getShipmentById(@PathVariable Long id) {
        return shipmentService.getShipmentById(id);
    }

    @PutMapping("/{id}")
    public Shipment updateShipment(@PathVariable Long id, @RequestBody ShipmentRequest request) {
        return shipmentService.updateShipment(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteShipmentById(@PathVariable Long id) {
        shipmentService.deleteShipmentById(id);
    }
}
