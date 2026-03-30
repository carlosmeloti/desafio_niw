package com.example.desafio_niw.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO {

    private String productId;
    private BigDecimal price;
    private Long quantity;
}
