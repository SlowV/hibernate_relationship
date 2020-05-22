package com.fintech.dao;

import com.fintech.entity.Order;
import org.hibernate.Session;

import java.util.Optional;

public class OrderDAO {
    private Session session;

    public OrderDAO(Session session) {
        this.session = session;
    }

    public Optional<Order> save(Order order) {
        session.save(order);
        return Optional.of(order);
    }
}
