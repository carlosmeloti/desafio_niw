package com.example.desafio_niw.controller;

import com.example.desafio_niw.data.Order;
import com.example.desafio_niw.data.enums.OrderStatus;
import com.example.desafio_niw.model.OrderDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/orders")
public interface OrderController {

    @PostMapping
    ResponseEntity<OrderDTO> create(@Valid @RequestBody OrderDTO order);

    @GetMapping("/customer/{customerId}")
    List<OrderDTO> findByCustomerId(@PathVariable Long customerId);

    @GetMapping
    List<OrderDTO> findAll();

    @GetMapping("/total/{id}")
    BigDecimal calculateTotalOrder(@PathVariable Long id);

    @GetMapping("/group-by-status")
    Map<OrderStatus, List<OrderDTO>> groupByStatus();

    @GetMapping("/most-expensive")
    Optional<OrderDTO> findMostExpensives();
}
