package com.chernomurov.warehousemanagement.service.product_minimal_amount;

import com.chernomurov.warehousemanagement.custom.http.request.ProductMinimalAmountRequest;
import com.chernomurov.warehousemanagement.entity.Equipment;
import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.ProductMinimalAmount;

public interface ProductMinimalAmountService {
    ProductMinimalAmount createProductMinimalAmount(ProductMinimalAmountRequest request);
    ProductMinimalAmount getProductMinimalAmountByProduct(Product product);
    ProductMinimalAmount updateProductMinimalAmount(Product product, ProductMinimalAmountRequest request);
    void deleteProductMinimalAmountByProduct(Product product);
}
