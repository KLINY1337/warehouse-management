package com.chernomurov.warehousemanagement.repository;

import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.StockManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockManagementRepository extends JpaRepository<StockManagement, Long> {
}
