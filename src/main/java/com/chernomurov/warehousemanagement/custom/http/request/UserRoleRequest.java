package com.chernomurov.warehousemanagement.custom.http.request;

import com.chernomurov.warehousemanagement.custom.http.DTO.UserDto;

import java.util.Set;

public record UserRoleRequest(
        Long id,
        String name,
        Set<UserDto> users) {
}
