package com.chernomurov.warehousemanagement.service.product_current_amount;

import com.chernomurov.warehousemanagement.custom.http.request.ProductCurrentAmountRequest;
import com.chernomurov.warehousemanagement.entity.Equipment;
import com.chernomurov.warehousemanagement.entity.EquipmentType;
import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.ProductCurrentAmount;

import java.util.Set;

public interface ProductCurrentAmountService {
    ProductCurrentAmount createProductCurrentAmount(ProductCurrentAmountRequest request);
    ProductCurrentAmount getProductCurrentAmountByProduct(Product product);
    ProductCurrentAmount updateProductCurrentAmount(Product product, ProductCurrentAmountRequest request);
    void deleteProductCurrentAmountByProduct(Product product);
}
