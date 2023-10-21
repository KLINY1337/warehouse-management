package com.chernomurov.warehousemanagement.repository;

import com.chernomurov.warehousemanagement.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
