package com.chernomurov.warehousemanagement.controller;

import com.chernomurov.warehousemanagement.custom.http.request.ProductCurrentAmountRequest;
import com.chernomurov.warehousemanagement.custom.http.request.ProductMinimalAmountRequest;
import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.ProductCurrentAmount;
import com.chernomurov.warehousemanagement.entity.ProductMinimalAmount;
import com.chernomurov.warehousemanagement.service.product_current_amount.ProductCurrentAmountService;
import com.chernomurov.warehousemanagement.service.product_minimal_amount.ProductMinimalAmountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product/current")
public class ProductCurrentAmountController {

    private final ProductCurrentAmountService productCurrentAmountService;

    @PostMapping("/{product:\\d+}")
    public ResponseEntity<ProductCurrentAmount> createProductCurrentAmount(@PathVariable("product") Product product, @RequestBody ProductCurrentAmountRequest request) {
        return ResponseEntity.ok(productCurrentAmountService.createProductCurrentAmount(product, request));
    }

    @GetMapping("/{product:\\d+}")
    public ResponseEntity<ProductCurrentAmount> getProductCurrentAmountByProduct(@PathVariable("product") Product product) {
        return ResponseEntity.ok(productCurrentAmountService.getProductCurrentAmountByProduct(product));
    }

    @PutMapping("/{product:\\d+}")
    public ResponseEntity<ProductCurrentAmount> updateProductCurrentAmount(@PathVariable("product") Product product, @RequestBody ProductCurrentAmountRequest request) {
        return ResponseEntity.ok(productCurrentAmountService.updateProductCurrentAmount(product, request));
    }

    @DeleteMapping("/{product:\\d+}")
    public void deleteProductCurrentAmountByProduct(@PathVariable("product") Product product) {
        productCurrentAmountService.deleteProductCurrentAmountByProduct(product);
    }
}
