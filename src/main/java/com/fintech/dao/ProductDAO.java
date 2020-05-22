package com.fintech.dao;

import com.fintech.entity.Product;
import org.hibernate.Session;

import java.util.Optional;

public class ProductDAO implements CrudDAO<Product, Long>{
    private Session session;

    public ProductDAO(Session session) {
        this.session = session;
    }

    @Override
    public Optional<Product> save(Product product) {
        session.save(product);
        return Optional.of(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return session.byId(Product.class).loadOptional(id);
    }
}
