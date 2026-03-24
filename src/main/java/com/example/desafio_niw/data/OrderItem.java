package com.example.desafio_niw.data;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class OrderItem {

    private Long id;
    private String productId;
    private BigDecimal price;
    private Long quantity;



}
