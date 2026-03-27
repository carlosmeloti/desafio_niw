package com.example.desafio_niw.controller;

import com.example.desafio_niw.data.Customer;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customers")
public interface CustomerController {

    @GetMapping
    List<Customer> findAll();
    @GetMapping("/{id}")
    Customer findById(Long id);
    @PostMapping
    Customer create(@Valid @RequestBody Customer customer);
    @PutMapping("/{id}")
    Customer update(@PathVariable Long id, @RequestBody Customer customer);
    @DeleteMapping("/{id}")
    void delete(Long id);

}
