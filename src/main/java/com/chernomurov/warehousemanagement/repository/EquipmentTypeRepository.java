package com.chernomurov.warehousemanagement.repository;

import com.chernomurov.warehousemanagement.entity.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EquipmentTypeRepository extends JpaRepository<EquipmentType, Long> {
    @Transactional
    @Modifying
    @Query("update EquipmentType e set e.name = ?1 where e.id = ?2")
    int updateNameById(String name, Long id);
}
