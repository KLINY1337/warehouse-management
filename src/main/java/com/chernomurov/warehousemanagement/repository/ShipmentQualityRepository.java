package com.chernomurov.warehousemanagement.repository;

import com.chernomurov.warehousemanagement.entity.Shipment;
import com.chernomurov.warehousemanagement.entity.ShipmentQuality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentQualityRepository extends JpaRepository<ShipmentQuality, Shipment> {
}
