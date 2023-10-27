package com.chernomurov.warehousemanagement.custom.http.request;

import com.chernomurov.warehousemanagement.custom.http.DTO.ProductDto;
import com.chernomurov.warehousemanagement.custom.http.DTO.WorkingTeamDto;

import java.util.Set;

public record ShipmentRequest(
        Long id,
        ProductDto product,
        Integer amount,
        Set<WorkingTeamDto> workingTeams) {
}
