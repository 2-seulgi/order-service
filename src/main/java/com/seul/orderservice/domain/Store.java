package com.seul.orderservice.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.ZonedDateTime;

@Table(name ="store")
@Getter
public class Store {

    @Id
    private String storeId;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private ZonedDateTime openAt;

    @Column
    private ZonedDateTime closeAt;
}
