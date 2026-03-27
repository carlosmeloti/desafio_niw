package com.example.desafio_niw.controller;

import com.example.desafio_niw.data.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/orders")
public interface OrderController {

    @PostMapping
    Order create(@RequestBody Order order);

    @GetMapping("/customer/{customerId}")
    List<Order> findByCustomerId(@PathVariable Long customerId);
}
