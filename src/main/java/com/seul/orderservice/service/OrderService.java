package com.seul.orderservice.service;

import com.seul.orderservice.domain.CreateOrder;
import com.seul.orderservice.domain.Order;
import com.seul.orderservice.repository.OrderRepository;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void newOrder(CreateOrder createOrder){
        Order entity = Order.newOrder(createOrder);
        orderRepository.save(entity);
    }
}
