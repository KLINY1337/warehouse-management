package com.chernomurov.warehousemanagement.service.product;

import com.chernomurov.warehousemanagement.custom.http.request.ProductRequest;
import com.chernomurov.warehousemanagement.entity.Equipment;
import com.chernomurov.warehousemanagement.entity.EquipmentType;
import com.chernomurov.warehousemanagement.entity.Product;

import java.math.BigDecimal;
import java.util.Set;

public interface ProductService {
    Product createProduct(ProductRequest request);
    Product getProductByArticleNumber(String articleNumber);
    Product updateProduct(String articleNumber, ProductRequest request);
    void deleteProductByArticleNumber(String articleNumber);
}
