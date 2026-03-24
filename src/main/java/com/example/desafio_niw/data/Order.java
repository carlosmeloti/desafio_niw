package com.example.desafio_niw.data;

import com.example.desafio_niw.data.enums.OrderStatus;
import lombok.Data;

import java.util.List;
@Data
public class Order {

    private Long  id;
    private String customerId;
    private List<OrderItem> items;
    private OrderStatus status;
}
