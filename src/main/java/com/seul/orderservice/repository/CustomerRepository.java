package com.seul.orderservice.repository;

import com.seul.orderservice.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer , Integer> {
}
