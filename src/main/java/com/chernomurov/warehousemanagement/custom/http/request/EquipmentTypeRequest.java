package com.chernomurov.warehousemanagement.custom.http.request;

import com.chernomurov.warehousemanagement.entity.Equipment;

import java.util.Set;

public record EquipmentTypeRequest(
        Long id,
        String name) {
}
