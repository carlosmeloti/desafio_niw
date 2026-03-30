package com.example.desafio_niw.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO {
    private Long id;
    private String productId;
    private BigDecimal price;
    private Long quantity;
}
