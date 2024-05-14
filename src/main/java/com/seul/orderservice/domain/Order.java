package com.seul.orderservice.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Table(name = "orders")
@Getter
public class Order {
    @Id
    private int orderId;

    @Column
    private int customerId;

    @Column
    private Timestamp orderedAt;

    // OrderItem과 1대 다 관계를 설정
    @MappedCollection(idColumn = "order_id", keyColumn = "order_item_id")
    private Set<OrderItem> orderItems = new HashSet<>();

    public Order(int customerId, Set<OrderItem>orderItems){
        this.customerId = customerId;
        this.orderedAt = Timestamp.valueOf(LocalDateTime.now());
        this.orderItems = orderItems;
    }
    public static Order newOrder(CreateOrder createOrder){
        Set<OrderItem> items = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry : createOrder.getQuantityByPredict().entrySet()){
            items.add(new OrderItem(entry.getKey(), entry.getValue()));
        }
        return new Order(createOrder.getCustomerId(), items);
    }
}
