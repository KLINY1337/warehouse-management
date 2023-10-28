package com.chernomurov.warehousemanagement.repository;

import com.chernomurov.warehousemanagement.entity.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderingRepository extends JpaRepository<Ordering, Long> {
}
