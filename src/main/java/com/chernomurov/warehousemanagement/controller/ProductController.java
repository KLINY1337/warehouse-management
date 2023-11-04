package com.chernomurov.warehousemanagement.controller;

import com.chernomurov.warehousemanagement.custom.http.request.ProductRequest;
import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @GetMapping("/{articleNumber}")
    public ResponseEntity<Product> getProductByArticleNumber(@PathVariable String articleNumber) {
        return ResponseEntity.ok(productService.getProductByArticleNumber(articleNumber));
    }

    @PutMapping("/{articleNumber}")
    public ResponseEntity<Product> updateProduct(@PathVariable String articleNumber, @RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.updateProduct(articleNumber, request));
    }

    @DeleteMapping("/{articleNumber}")
    public void deleteProductByArticleNumber(@PathVariable String articleNumber) {
        productService.deleteProductByArticleNumber(articleNumber);
    }
}
