package com.chernomurov.warehousemanagement.custom.http.request;

import com.chernomurov.warehousemanagement.custom.http.DTO.ProductDto;
import com.chernomurov.warehousemanagement.custom.http.DTO.UserDto;
import com.chernomurov.warehousemanagement.custom.http.DTO.WorkingTeamDto;
import com.chernomurov.warehousemanagement.entity.WorkingTeam;

import java.time.LocalDateTime;
import java.util.Set;

public record OrderingRequest(
        Long id,
        ProductDto product,
        String consumer,
        Integer amount,
        LocalDateTime date,
        UserDto responsibleUser) {
}
