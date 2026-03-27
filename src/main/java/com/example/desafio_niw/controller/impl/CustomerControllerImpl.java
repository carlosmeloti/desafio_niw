package com.example.desafio_niw.controller.impl;

import com.example.desafio_niw.controller.CustomerController;
import com.example.desafio_niw.data.Customer;
import com.example.desafio_niw.data.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerControllerImpl implements CustomerController {

    private final CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        // Aqui ta listando tudo.... Tudo que nao devemos fazer, não é mesmo inimigo da performance?
        // Ja ajusto isso. Uma paginação vai ficar fixe.
        // Preciso mesmo de um projeto pra ontem. Ja ando a conversar com meu codigo.
        // Mas hoje é sexta... minha esposa faz anos e acho que vou ter um dia feliz.
        return customerRepository.findAll();
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
