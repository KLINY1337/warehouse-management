package com.chernomurov.warehousemanagement.repository;

import com.chernomurov.warehousemanagement.entity.Shipment;
import com.chernomurov.warehousemanagement.entity.SupplierContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierContractRepository extends JpaRepository<SupplierContract, Long> {
}
