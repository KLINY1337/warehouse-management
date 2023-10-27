package com.chernomurov.warehousemanagement.service.user;

import com.chernomurov.warehousemanagement.custom.http.request.UserRequest;
import com.chernomurov.warehousemanagement.entity.Supplier;
import com.chernomurov.warehousemanagement.entity.SupplierRate;
import com.chernomurov.warehousemanagement.entity.User;
import com.chernomurov.warehousemanagement.entity.UserRole;

import java.math.BigDecimal;
import java.util.Set;

public interface UserService {
    User createUser(UserRequest request);
    User getUserById(Long id);
    User updateUser(Long id, UserRequest request);
    void deleteUserById(Long id);
}
