package com.fintech.dao;

import java.util.Optional;

public interface CrudDAO<Type, Key> {
    Optional<Type> save(Type t);
    Optional<Type> findById(Key k);
}
