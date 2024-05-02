package com.seul.orderservice.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class CreateOrder {
    private int customerId;
    private Map<Integer, Integer> quantityByPredict; // ["라떼"(상품아이디값), 3]
}
