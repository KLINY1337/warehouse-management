package com.chernomurov.warehousemanagement.controller;

import com.chernomurov.warehousemanagement.custom.http.request.ProductMinimalAmountRequest;
import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.ProductMinimalAmount;
import com.chernomurov.warehousemanagement.service.product_minimal_amount.ProductMinimalAmountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product/minimal")
public class ProductMinimalAmountController {

    private final ProductMinimalAmountService productMinimalAmountService;

    @PostMapping("/{product:\\d+}")
    public ProductMinimalAmount createProductMinimalAmount(@PathVariable("product") Product product, @RequestBody ProductMinimalAmountRequest request) {
        return productMinimalAmountService.createProductMinimalAmount(product, request);
    }

    @GetMapping("/{product:\\d+}")
    public ProductMinimalAmount getProductMinimalAmountByProduct(@PathVariable Product product) {
        return productMinimalAmountService.getProductMinimalAmountByProduct(product);
    }

    @PutMapping("/{product:\\d+}")
    public ProductMinimalAmount updateProductMinimalAmount(@PathVariable Product product, @RequestBody ProductMinimalAmountRequest request) {
        return productMinimalAmountService.updateProductMinimalAmount(product, request);
    }

    @DeleteMapping("/{product:\\d+}")
    public void deleteProductMinimalAmountByProduct(@PathVariable Product product) {
        productMinimalAmountService.deleteProductMinimalAmountByProduct(product);
    }
}
