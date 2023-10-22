package com.chernomurov.warehousemanagement.service.order;

import com.chernomurov.warehousemanagement.entity.*;

import java.time.LocalDateTime;
import java.util.Set;

public interface OrderService {
    void createOrder(Product product, String consumer, Integer amount, LocalDateTime date, Set<WorkingTeam> workingTeams, User responsibleUser);
    Order getOrderById(Long id);
    void updateOrder(Long id, Product product, String consumer, Integer amount, LocalDateTime date, Set<WorkingTeam> workingTeams, User responsibleUser);
    void deleteOrderById(Long id);
}
