package com.example.desafio_niw.controller.impl;

import com.example.desafio_niw.controller.OrderController;
import com.example.desafio_niw.data.Order;
import com.example.desafio_niw.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return List.of();
    }
}
