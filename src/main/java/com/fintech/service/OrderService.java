package com.fintech.service;

import com.fintech.dao.OrderDAO;
import com.fintech.entity.Order;
import com.fintech.entity.OrderException;
import com.fintech.entity.Product;
import com.fintech.entity.ProductException;
import com.fintech.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.PersistenceException;
import java.util.Optional;

public class OrderService {
    private Session session = HibernateUtil.getSession();
    private OrderDAO orderDAO = new OrderDAO(session);


    public Order addOrder(Order order) {
        Transaction transaction = null;
        Optional<Order> optional = Optional.empty();
        try {
            transaction = session.beginTransaction();
            optional = orderDAO.save(order);
            transaction.commit();
        } catch (PersistenceException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return optional.orElseThrow(() -> new OrderException("Order save failed!"));
    }
}
