package com.example.desafio_niw.controller.impl;

import com.example.desafio_niw.controller.OrderController;
import com.example.desafio_niw.data.Order;
import com.example.desafio_niw.data.enums.OrderStatus;
import com.example.desafio_niw.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class OrderControllerImpl implements OrderController {

    private final OrderService orderService;

    @Override
    public Order create(Order order) {
        return orderService.create(order);
    }

    @Override
    public List<Order> findByCustomerId(Long customerId) {
        return orderService.findByCustomerId(customerId);
    }

    @Override
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @Override
    public BigDecimal calculateTotal(Long id) {
        Order order = orderService.findAll().stream()
                .filter(o -> o.getId() != null && o.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order not found with0 id: " + id));

        return orderService.calculateTotal(order);
    }

    @Override
    public Map<OrderStatus, List<Order>> groupByStatus() {
        return orderService.groupByStatus(orderService.findAll());
    }

    @Override
    public Optional<Order> findMostExpensives() {
        return orderService.findMostExpensives(orderService.findAll());
    }

}
