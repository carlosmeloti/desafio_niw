package com.example.desafio_niw.controller.impl;

import com.example.desafio_niw.controller.CustomerController;
import com.example.desafio_niw.data.Customer;
import com.example.desafio_niw.data.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerControllerImpl implements CustomerController {

    private final CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll(int page, int size) {
        return customerRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Long id, Customer customer) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        //Um mapstruct ia bem aqui.

        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());

        return customerRepository.save(existingCustomer);
    }

    @Override
    public void delete(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer não encontrado com id: " + id);
        }
        // O usual aqui é usar a exclusão lógica. Um status que habilita e desabilita para não se perder o registro. Ops... sorry... registOoooo
        customerRepository.deleteById(id);
    }
}
