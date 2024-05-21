package com.seul.orderservice.controller;

import com.seul.orderservice.domain.CreateOrder;
import com.seul.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/api/v1/orders")
    public Response<Void> newOrder(){
        Map<Integer, Integer>orderMap = new HashMap<>();
        orderMap.put(1,5);
        orderMap.put(2,18);

        orderService.newOrder(CreateOrder.builder()
                        .customerId(1)
                        .quantityByPredict(orderMap)
                        .build());
        return Response.success(null);

    }
    
}
