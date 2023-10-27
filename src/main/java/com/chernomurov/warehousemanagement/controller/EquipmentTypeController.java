package com.chernomurov.warehousemanagement.controller;

import com.chernomurov.warehousemanagement.custom.http.request.EquipmentTypeRequest;
import com.chernomurov.warehousemanagement.entity.EquipmentType;
import com.chernomurov.warehousemanagement.service.equipment_type.EquipmentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/equipment/type")
public class EquipmentTypeController {

    private final EquipmentTypeService equipmentTypeService;

    @PostMapping
    public EquipmentType createEquipmentType(@RequestBody EquipmentTypeRequest request) {
        return equipmentTypeService.createEquipmentType(request);
    }

    @GetMapping("/{id}")
    public EquipmentType getEquipmentTypeById(@PathVariable Long id) {
        return equipmentTypeService.getEquipmentTypeById(id);

    }

    @PutMapping("/{id}")
    public EquipmentType updateEquipmentType(@PathVariable Long id, @RequestBody EquipmentTypeRequest request) {
        return equipmentTypeService.updateEquipmentType(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipmentTypeById(@PathVariable Long id) {
        equipmentTypeService.deleteEquipmentTypeById(id);
    }
}
