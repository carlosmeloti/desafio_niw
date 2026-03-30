package com.example.desafio_niw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;
@Data
public class CustomerDTO {
    private String name;
    private String email;
    @JsonIgnore
    private List<OrderDTO> orders;
}
