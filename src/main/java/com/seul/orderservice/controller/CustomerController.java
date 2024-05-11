package com.seul.orderservice.controller;

import com.seul.orderservice.domain.CreateCustomer;
import com.seul.orderservice.domain.Customer;
import com.seul.orderservice.domain.CustomerDto;
import com.seul.orderservice.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/api/v1/customers")
    public Response<CustomerDto> createNewCustomers(
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ){
        return Response.success(customerService.newCustomer(
                CreateCustomer.builder()
                        .address(address)
                        .phoneNumber(phoneNumber)
                        .name(name)
                        .build()
                        )
        );
    }
}
