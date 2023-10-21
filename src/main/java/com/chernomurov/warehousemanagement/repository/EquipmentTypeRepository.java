package com.chernomurov.warehousemanagement.repository;

import com.chernomurov.warehousemanagement.entity.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentTypeRepository extends JpaRepository<EquipmentType, Long> {
}
