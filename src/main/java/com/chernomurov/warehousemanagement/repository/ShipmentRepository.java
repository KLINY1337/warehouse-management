package com.chernomurov.warehousemanagement.repository;

import com.chernomurov.warehousemanagement.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
