package com.chernomurov.warehousemanagement.custom.http.request;

import com.chernomurov.warehousemanagement.custom.http.DTO.UserRoleDto;

import java.util.Set;

public record UserRequest(
        Long id,
        String name,
        String surname,
        String patronymic,
        String password,
        Set<UserRoleDto> userRoles) {
}
