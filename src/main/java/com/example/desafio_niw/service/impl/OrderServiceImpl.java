package com.example.desafio_niw.service.impl;

import com.example.desafio_niw.data.Customer;
import com.example.desafio_niw.data.Order;
import com.example.desafio_niw.data.enums.OrderStatus;
import com.example.desafio_niw.repository.OrderRepository;
import com.example.desafio_niw.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    public static OrderRepository orderRepository;

    @Override
    public BigDecimal calculateTotal(Order order) {
        return null;
    }

    @Override
    public List<Order> getOrdersByCustomers(List<Order> orders, Customer customer) {
        return List.of();
    }

    @Override
    public Map<OrderStatus, List<Order>> getOrdersByStatus(List<Order> orders) {
        return Map.of();
    }

    @Override
    public Optional<Order> findMostExpensives(List<Order> orders) {
        return Optional.empty();
    }
}
