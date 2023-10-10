package com.chernomurov.warehousemanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierContract {

    @Id
    @OneToOne
    private Shipment shipment;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "responsible_user_id")
    private User responsibleUser;

    private LocalDateTime deliveryTime;

    private LocalDateTime storageTime;

    private String storingConditions;
}
