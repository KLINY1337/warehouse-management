package com.chernomurov.warehousemanagement.repository;

import com.chernomurov.warehousemanagement.entity.WorkingTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingTeamRepository extends JpaRepository<WorkingTeam, Long> {
}