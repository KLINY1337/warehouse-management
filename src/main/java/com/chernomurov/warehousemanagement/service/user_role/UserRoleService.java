package com.chernomurov.warehousemanagement.service.user_role;

import com.chernomurov.warehousemanagement.custom.http.request.UserRoleRequest;
import com.chernomurov.warehousemanagement.entity.User;
import com.chernomurov.warehousemanagement.entity.UserRole;

import java.util.Set;

public interface UserRoleService {
    UserRole createUserRole(UserRoleRequest request);
    UserRole getUserRoleById(Long id);
    UserRole updateUserRole(Long id, UserRoleRequest request);
    void deleteUserRoleById(Long id);
}
