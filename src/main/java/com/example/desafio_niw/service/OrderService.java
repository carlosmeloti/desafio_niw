package com.example.desafio_niw.service;

import com.example.desafio_niw.data.Order;
import com.example.desafio_niw.data.enums.OrderStatus;
import com.example.desafio_niw.model.OrderDTO;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderService {

    BigDecimal calculateTotal(OrderDTO order);
    BigDecimal calculateTotalOrder(Long id);
    Map<OrderStatus, List<OrderDTO>> groupByStatus(List<OrderDTO> orders);
    Optional<OrderDTO> findMostExpensives(List<OrderDTO> orders);

    OrderDTO create(OrderDTO order);
    List<OrderDTO> findByCustomerId(Long customerId);
    List<OrderDTO> findAllPageable(Pageable pageable);
    List<OrderDTO> findAll();
}
