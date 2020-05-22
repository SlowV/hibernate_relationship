package com.fintech.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "OrderDetail")
public class OrderDetail implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    private Order order;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    private int unitPrice;
    private int quantity;

    public OrderDetail() {
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
