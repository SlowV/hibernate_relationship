package com.fintech.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity(name = "Order")
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "total")
    private int total;

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Set<OrderDetail> orderDetailSet = new HashSet<>();

    public Order() {
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetail.setOrder(this);
        this.total += orderDetail.getUnitPrice() * orderDetail.getQuantity();
        this.orderDetailSet.add(orderDetail);
    }
}
