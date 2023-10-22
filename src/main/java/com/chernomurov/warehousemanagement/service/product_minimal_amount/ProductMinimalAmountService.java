package com.chernomurov.warehousemanagement.service.product_minimal_amount;

import com.chernomurov.warehousemanagement.entity.Equipment;
import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.ProductMinimalAmount;

public interface ProductMinimalAmountService {
    void createProductMinimalAmount(Product product, Integer minimalAmount);
    ProductMinimalAmount getProductMinimalAmountByProduct(Product product);
    void updateProductMinimalAmount(Product product, Integer minimalAmount);
    void deleteProductMinimalAmountByProduct(Product product);
}
