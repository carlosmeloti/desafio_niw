package com.example.desafio_niw.controller.impl;

import com.example.desafio_niw.controller.OrderController;
import com.example.desafio_niw.data.enums.OrderStatus;
import com.example.desafio_niw.model.OrderDTO;
import com.example.desafio_niw.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<OrderDTO> create(OrderDTO order) {
        OrderDTO created = orderService.create(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @Override
    public List<OrderDTO> findByCustomerId(Long customerId) {
        return orderService.findByCustomerId(customerId);
    }

    @Override
    public List<OrderDTO> findAll() {
        return orderService.findAll();
    }

    @Override
    public BigDecimal calculateTotalOrder(Long id) {
        return orderService.calculateTotalOrder(id);
    }

    @Override
    public Map<OrderStatus, List<OrderDTO>> groupByStatus() {
        return orderService.groupByStatus(orderService.findAll());
    }

    @Override
    public Optional<OrderDTO> findMostExpensives() {
        return orderService.findMostExpensives(orderService.findAll());
    }

}
