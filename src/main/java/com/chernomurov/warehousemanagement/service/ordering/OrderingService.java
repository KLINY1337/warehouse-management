package com.chernomurov.warehousemanagement.service.ordering;

import com.chernomurov.warehousemanagement.custom.http.request.OrderingRequest;
import com.chernomurov.warehousemanagement.entity.*;

import java.time.LocalDateTime;
import java.util.Set;

public interface OrderingService {
    Ordering createOrder(OrderingRequest request);
    Ordering getOrderById(Long id);
    Ordering updateOrder(Long id, OrderingRequest request);
    void deleteOrderById(Long id);
}
