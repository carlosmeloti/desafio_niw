package com.example.desafio_niw.model;

import com.example.desafio_niw.data.Order;
import lombok.Data;

import java.util.List;
@Data
public class CustomerDTO {
    private String name;
    private String email;
    private List<Order> orders;
}
