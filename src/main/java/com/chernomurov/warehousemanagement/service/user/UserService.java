package com.chernomurov.warehousemanagement.service.user;

import com.chernomurov.warehousemanagement.entity.Supplier;
import com.chernomurov.warehousemanagement.entity.SupplierRate;
import com.chernomurov.warehousemanagement.entity.User;
import com.chernomurov.warehousemanagement.entity.UserRole;

import java.math.BigDecimal;
import java.util.Set;

public interface UserService {
    void createUser(String name, String surname, String patronymic, String password, Set<UserRole> userRoles);
    User getUserById(Long id);
    void updateUser(Long id, String name, String surname, String patronymic, String password, Set<UserRole> userRoles);
    void deleteUserById(Long id);
}
