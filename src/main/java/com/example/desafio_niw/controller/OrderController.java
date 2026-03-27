package com.example.desafio_niw.controller;

import com.example.desafio_niw.data.Order;
import com.example.desafio_niw.data.enums.OrderStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/orders")
public interface OrderController {

    @PostMapping
    Order create(@RequestBody Order order);

    @GetMapping("/customer/{customerId}")
    List<Order> findByCustomerId(@PathVariable Long customerId);

    @GetMapping
    List<Order> findAll();

    @GetMapping("/total/{id}")
    BigDecimal calculateTotal(@PathVariable Long id);

    @GetMapping("/group-by-status")
    Map<OrderStatus, List<Order>> groupByStatus();

    @GetMapping("/most-expensive")
    Optional<Order> findMostExpensives();
}
