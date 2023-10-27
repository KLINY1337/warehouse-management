package com.chernomurov.warehousemanagement.custom.http.request;

import com.chernomurov.warehousemanagement.custom.http.DTO.EquipmentTypeDto;

import java.util.Set;

public record EquipmentRequest(
        String name,
        Set<EquipmentTypeDto> equipmentTypes)
{}
