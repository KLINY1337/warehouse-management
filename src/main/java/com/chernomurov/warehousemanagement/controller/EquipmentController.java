package com.chernomurov.warehousemanagement.controller;

import com.chernomurov.warehousemanagement.custom.http.request.EquipmentRequest;
import com.chernomurov.warehousemanagement.entity.Equipment;
import com.chernomurov.warehousemanagement.service.equipment.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    @PostMapping
    public Equipment createEquipment(@RequestBody EquipmentRequest request) {
        return equipmentService.createEquipment(request);
    }

    @GetMapping("/{id}")
    public Equipment getEquipmentById(@PathVariable Long id) {
        return equipmentService.getEquipmentById(id);
    }

    @PutMapping("/{id}")
    public Equipment updateEquipment(@PathVariable Long id, @RequestBody EquipmentRequest request) {
        return equipmentService.updateEquipment(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipmentById(@PathVariable Long id) {
        equipmentService.deleteEquipmentById(id);
    }
}
