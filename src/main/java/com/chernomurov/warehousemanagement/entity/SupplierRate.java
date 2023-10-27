package com.chernomurov.warehousemanagement.entity;

import com.chernomurov.warehousemanagement.entity.id_class.SupplierId;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(SupplierId.class)
public class SupplierRate {

    @Id
//    @OneToOne
//    @JoinColumn(name = "supplier_id")
    @Column(name = "supplier_id")
    private Long supplierId;

    private BigDecimal reliabilityRate;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        SupplierRate that = (SupplierRate) o;
        return getSupplierId() != null && Objects.equals(getSupplierId(), that.getSupplierId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
