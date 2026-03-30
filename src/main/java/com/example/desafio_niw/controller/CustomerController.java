package com.example.desafio_niw.controller;

import com.example.desafio_niw.data.Customer;
import com.example.desafio_niw.model.CustomerDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customers")
public interface CustomerController {

    @GetMapping
    List<CustomerDTO> findAll(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size);
    @GetMapping("/{id}")
    CustomerDTO findById(@PathVariable Long id);
    @PostMapping
    CustomerDTO create(@Valid @RequestBody CustomerDTO customer);
    @PutMapping("/{id}")
    CustomerDTO update(@PathVariable Long id, @RequestBody CustomerDTO customer);
    @DeleteMapping("/{id}")
    void delete(Long id);

}
