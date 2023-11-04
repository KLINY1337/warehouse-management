package com.chernomurov.warehousemanagement.controller;

import com.chernomurov.warehousemanagement.custom.http.request.OrderingRequest;
import com.chernomurov.warehousemanagement.entity.Ordering;
import com.chernomurov.warehousemanagement.service.ordering.OrderingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/ordering")
public class OrderingController {

    private final OrderingService orderingService;

    @PostMapping
    public ResponseEntity<Ordering> createOrder(@RequestBody OrderingRequest request) {
        return ResponseEntity.ok(orderingService.createOrder(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ordering> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderingService.getOrderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ordering> updateOrder(@PathVariable Long id, @RequestBody OrderingRequest request) {
        return ResponseEntity.ok(orderingService.updateOrder(id, request));
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id) {
        orderingService.deleteOrderById(id);
    }
}
