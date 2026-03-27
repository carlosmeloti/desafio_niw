package com.example.desafio_niw.data.repository;

import com.example.desafio_niw.data.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
