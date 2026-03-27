package com.example.desafio_niw.service;

import com.example.desafio_niw.data.Order;
import com.example.desafio_niw.data.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderService {

    BigDecimal calculateTotal(Order order);
    List<Order> getOrdersByCustomers(List<Order> orders, String customerId);
    Map<OrderStatus, List<Order>> groupByStatus(List<Order> orders);
    Optional<Order> findMostExpensives(List<Order> orders);

    Order create(Order order);
    List<Order> findByCustomerId(Long customerId);
    List<Order> findAll();
}
