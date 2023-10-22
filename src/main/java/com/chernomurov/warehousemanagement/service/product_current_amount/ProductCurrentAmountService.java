package com.chernomurov.warehousemanagement.service.product_current_amount;

import com.chernomurov.warehousemanagement.entity.Equipment;
import com.chernomurov.warehousemanagement.entity.EquipmentType;
import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.ProductCurrentAmount;

import java.util.Set;

public interface ProductCurrentAmountService {
    void createProductCurrentAmount(Product product, Long currentAmount);
    ProductCurrentAmount getProductCurrentAmountByProduct(Product product);
    void updateProductCurrentAmount(Product product, Long currentAmount);
    void deleteProductCurrentAmountByProduct(Product product);
}
