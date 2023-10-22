package com.chernomurov.warehousemanagement.service.user_role;

import com.chernomurov.warehousemanagement.entity.User;
import com.chernomurov.warehousemanagement.entity.UserRole;

import java.util.Set;

public interface UserRoleService {
    void createUserRole(String name);
    UserRole getUserRoleById(Long id);
    void updateUserRole(Long id, String name);
    void deleteUserRoleById(Long id);
}
