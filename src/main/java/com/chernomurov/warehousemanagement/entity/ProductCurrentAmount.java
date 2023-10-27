package com.chernomurov.warehousemanagement.entity;

import com.chernomurov.warehousemanagement.entity.id_class.ProductId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ProductId.class)
public class ProductCurrentAmount {

    @Id
//    @OneToOne
//    @JoinColumn(name = "product_article_number")
    @Column(name = "product_article_number")
    private String productArticleNumber;

    private Long currentAmount;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        ProductCurrentAmount that = (ProductCurrentAmount) o;
        return getProductArticleNumber() != null && Objects.equals(getProductArticleNumber(), that.getProductArticleNumber());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(productArticleNumber);
    }
}
