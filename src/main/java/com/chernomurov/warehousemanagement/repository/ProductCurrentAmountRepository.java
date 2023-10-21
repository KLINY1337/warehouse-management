package com.chernomurov.warehousemanagement.repository;

import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.ProductCurrentAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCurrentAmountRepository extends JpaRepository<ProductCurrentAmount, Product> {
}
