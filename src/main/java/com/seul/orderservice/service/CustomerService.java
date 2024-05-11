package com.seul.orderservice.service;

import com.seul.orderservice.domain.CreateCustomer;
import com.seul.orderservice.domain.Customer;
import com.seul.orderservice.domain.CustomerDto;
import com.seul.orderservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public CustomerDto newCustomer(CreateCustomer customer){
        Customer entity = Customer.newCustomer(customer);
        Customer saved = customerRepository.save(entity);

        return CustomerDto.builder()
                .address(saved.getAddress())
                .phoneNumber(saved.getPhoneNumber())
                .name(saved.getName())
                .build();
    }
}
