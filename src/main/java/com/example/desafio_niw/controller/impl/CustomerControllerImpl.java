package com.example.desafio_niw.controller.impl;

import com.example.desafio_niw.controller.CustomerController;
import com.example.desafio_niw.data.Customer;
import com.example.desafio_niw.data.repository.CustomerRepository;
import com.example.desafio_niw.model.CustomerDTO;
import com.example.desafio_niw.model.mapper.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerControllerImpl implements CustomerController {

    private final CustomerRepository customerRepository;
    private final EntityMapper entityMapper;
    @Override
    public List<CustomerDTO> findAll(int page, int size) {
        return entityMapper.entityToCustomerDTOList(customerRepository.findAll(PageRequest.of(page, size)).getContent());
    }

    @Override
    public CustomerDTO findById(Long id) {
        return entityMapper.entityToCustomerDTO(customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id)));
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer customer = entityMapper.CustomerDTOToEntity(customerDTO);
        return entityMapper.entityToCustomerDTO(customerRepository.save(customer));
    }

    @Override
    public CustomerDTO update(Long id, CustomerDTO customerDTO) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        entityMapper.updateCustomerFromDTO(customerDTO, existingCustomer);
        Customer saved = customerRepository.save(existingCustomer);
        return entityMapper.entityToCustomerDTO(saved);
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
