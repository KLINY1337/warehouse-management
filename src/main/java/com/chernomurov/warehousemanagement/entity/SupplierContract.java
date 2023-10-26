package com.chernomurov.warehousemanagement.entity;

import com.chernomurov.warehousemanagement.entity.id.ShipmentId;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(ShipmentId.class)
public class SupplierContract {

    @Id
//    @OneToOne
//    @JoinColumn(name = "shipment_id")
    @Column(name = "shipment_id")
    private Long shipmentId;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "responsible_user_id")
    private User responsibleUser;

    private LocalDateTime deliveryTime;

    private LocalDateTime storageTime;

    private String storingConditions;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        SupplierContract that = (SupplierContract) o;
        return getShipmentId() != null && Objects.equals(getShipmentId(), that.getShipmentId());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(shipmentId);
    }
}
