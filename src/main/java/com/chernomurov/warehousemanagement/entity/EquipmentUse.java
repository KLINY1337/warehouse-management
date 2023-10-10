package com.chernomurov.warehousemanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipmentUse {

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "working_team_id", nullable = false)
    private WorkingTeam workingTeam;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;
}
