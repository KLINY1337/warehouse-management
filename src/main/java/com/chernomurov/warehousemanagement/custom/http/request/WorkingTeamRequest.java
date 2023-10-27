package com.chernomurov.warehousemanagement.custom.http.request;

import com.chernomurov.warehousemanagement.custom.http.DTO.OrderingDto;
import com.chernomurov.warehousemanagement.custom.http.DTO.ShipmentDto;
import com.chernomurov.warehousemanagement.custom.http.DTO.UserDto;

import java.util.Set;

public record WorkingTeamRequest(
        Long id,
        UserDto manager,
        Integer peopleAmount,
        String specialization,
        Set<OrderingDto> orderings, Set<ShipmentDto> shipments) {
}
