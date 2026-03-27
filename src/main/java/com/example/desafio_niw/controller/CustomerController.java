package com.example.desafio_niw.controller;

import com.example.desafio_niw.data.Customer;

import java.util.List;

public interface CustomerController {

    List<Customer> findAll();
    Customer findById(Long id);
    Customer create(Customer customer);
    Customer update(Long id, Customer customer);
    void delete(Long id);

}
