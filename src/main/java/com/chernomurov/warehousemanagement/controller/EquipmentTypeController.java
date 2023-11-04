package com.chernomurov.warehousemanagement.controller;

import com.chernomurov.warehousemanagement.custom.http.request.EquipmentTypeRequest;
import com.chernomurov.warehousemanagement.entity.EquipmentType;
import com.chernomurov.warehousemanagement.service.equipment_type.EquipmentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/equipment/type")
public class EquipmentTypeController {

    private final EquipmentTypeService equipmentTypeService;

    @PostMapping
    public ResponseEntity<EquipmentType> createEquipmentType(@RequestBody EquipmentTypeRequest request) {
        return ResponseEntity.ok(equipmentTypeService.createEquipmentType(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentType> getEquipmentTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(equipmentTypeService.getEquipmentTypeById(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipmentType> updateEquipmentType(@PathVariable Long id, @RequestBody EquipmentTypeRequest request) {
        return ResponseEntity.ok(equipmentTypeService.updateEquipmentType(id, request));
    }

    @DeleteMapping("/{id}")
    public void deleteEquipmentTypeById(@PathVariable Long id) {
        equipmentTypeService.deleteEquipmentTypeById(id);
    }
}
