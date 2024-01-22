package io.matheusvictor.service;

import io.matheusvictor.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void create(Customer customer);
}
