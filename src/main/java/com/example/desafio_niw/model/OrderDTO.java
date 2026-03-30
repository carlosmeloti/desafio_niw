package com.example.desafio_niw.model;

import com.example.desafio_niw.data.Customer;
import com.example.desafio_niw.data.enums.OrderStatus;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private CustomerDTO customer;
    private List<OrderItemDTO> items;
    private OrderStatus status;
}
