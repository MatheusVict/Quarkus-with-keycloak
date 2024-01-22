package io.matheusvictor.service.impl;

import io.matheusvictor.domain.Customer;
import io.matheusvictor.repository.CustomerRepository;
import io.matheusvictor.service.CustomerService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class CustomerServiceImpl implements CustomerService {

    @Inject
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll().list();
    }

    @Override
    public void create(Customer customer) {
        customerRepository.persist(customer);
    }
}
