package com.chernomurov.warehousemanagement.repository;

import com.chernomurov.warehousemanagement.entity.Supplier;
import com.chernomurov.warehousemanagement.entity.SupplierRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRateRepository extends JpaRepository<SupplierRate, Supplier> {
}
