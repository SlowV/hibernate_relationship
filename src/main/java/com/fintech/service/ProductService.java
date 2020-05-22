package com.fintech.service;

import com.fintech.dao.ProductDAO;
import com.fintech.entity.Product;
import com.fintech.entity.ProductException;
import com.fintech.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.PersistenceException;
import java.util.Optional;

public class ProductService {
    private Session session = HibernateUtil.getSession();
    private ProductDAO productDAO = new ProductDAO(session);

    public Product addProduct(Product product) {
        Transaction transaction = null;
        Optional<Product> optional = Optional.empty();
        try {
            transaction = session.beginTransaction();
            optional = productDAO.save(product);
            transaction.commit();
        } catch (PersistenceException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return optional.orElseThrow(() -> new ProductException("Product save failed!"));
    }

    public Product getById(Long id) {
        return productDAO.findById(id)
                .orElseThrow(() -> new ProductException("Get product by id failed!"));
    }
}
