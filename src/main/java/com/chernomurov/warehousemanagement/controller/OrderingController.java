package com.chernomurov.warehousemanagement.controller;

import com.chernomurov.warehousemanagement.custom.http.request.OrderingRequest;
import com.chernomurov.warehousemanagement.entity.Ordering;
import com.chernomurov.warehousemanagement.service.ordering.OrderingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/ordering")
public class OrderingController {

    private final OrderingService orderingService;

    @PostMapping
    public Ordering createOrder(@RequestBody OrderingRequest request) {
        return orderingService.createOrder(request);
    }

    @GetMapping("/{id}")
    public Ordering getOrderById(@PathVariable Long id) {
        return orderingService.getOrderById(id);
    }

    @PutMapping("/{id}")
    public Ordering updateOrder(@PathVariable Long id, @RequestBody OrderingRequest request) {
        return updateOrder(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id) {
        deleteOrderById(id);
    }
}
