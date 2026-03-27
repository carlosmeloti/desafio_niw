package com.example.desafio_niw.service.impl;

import com.example.desafio_niw.data.Order;
import com.example.desafio_niw.data.OrderItem;
import com.example.desafio_niw.data.enums.OrderStatus;
import com.example.desafio_niw.data.repository.OrderRepository;
import com.example.desafio_niw.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public BigDecimal calculateTotal(Order order) {

        BigDecimal total = BigDecimal.ZERO;

        if (order == null || order.getItems() == null) {
            return BigDecimal.ZERO;
        }

        for (OrderItem item : order.getItems()) {
            BigDecimal subtotal = item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            total = total.add(subtotal);
        }
        return total;
    }

    @Override
    public List<Order> getOrdersByCustomers(List<Order> orders, String customerId) {
        if (orders == null || customerId == null) {
            return List.of();
        }

        return orders.stream()
                .filter(order -> order.getCustomer() != null
                        && order.getCustomer().getId() != null
                        && customerId.equals(String.valueOf(order.getCustomer().getId())))
                .toList();
    }

    @Override
    public Map<OrderStatus, List<Order>> groupByStatus(List<Order> orders) {
        if (orders == null) {
            return Map.of();
        }
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus));
    }

    @Override
    public Optional<Order> findMostExpensives(List<Order> orders) {
        if (orders == null) {
            return Optional.empty();
        }
        return orders.stream()
                .max(Comparator.comparing(this::calculateTotal));
    }

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> findByCustomerId(Long customerId) {
        if (customerId == null) {
            return List.of();
        }
        return orderRepository.findByCustomerId(customerId);
    }
}
