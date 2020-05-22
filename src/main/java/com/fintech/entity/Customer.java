package com.fintech.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "Customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders = new HashSet<>();

    public Customer() {
    }


    public Customer(String name) {
        this.name = name;
    }
}
