package com.chernomurov.warehousemanagement.service.product;

import com.chernomurov.warehousemanagement.entity.Equipment;
import com.chernomurov.warehousemanagement.entity.EquipmentType;
import com.chernomurov.warehousemanagement.entity.Product;

import java.math.BigDecimal;
import java.util.Set;

public interface ProductService {
    void createProduct(String articleNumber, String name, String description, BigDecimal price);
    Product getProductByArticleNumber(String articleNumber);
    void updateProduct(String articleNumber, String name, String description, BigDecimal price);
    void deleteProductByArticleNumber(String articleNumber);
}
