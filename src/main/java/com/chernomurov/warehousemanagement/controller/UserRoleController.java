package com.chernomurov.warehousemanagement.controller;

import com.chernomurov.warehousemanagement.custom.http.request.UserRoleRequest;
import com.chernomurov.warehousemanagement.entity.UserRole;
import com.chernomurov.warehousemanagement.service.user_role.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user/role")
public class UserRoleController {

    private final UserRoleService userRoleService;

    @PostMapping
    public UserRole createUserRole(@RequestBody UserRoleRequest request) {
        return userRoleService.createUserRole(request);
    }

    @GetMapping("/{id}")
    public UserRole getUserRoleById(@PathVariable Long id) {
        return userRoleService.getUserRoleById(id);
    }

    @PutMapping("/{id}")
    public UserRole updateUserRole(@PathVariable Long id, @RequestBody UserRoleRequest request) {
        return userRoleService.updateUserRole(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteUserRoleById(@PathVariable Long id) {
        userRoleService.deleteUserRoleById(id);
    }
}
