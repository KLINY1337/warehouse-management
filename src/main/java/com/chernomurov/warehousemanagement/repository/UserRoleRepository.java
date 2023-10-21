package com.chernomurov.warehousemanagement.repository;

import com.chernomurov.warehousemanagement.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}