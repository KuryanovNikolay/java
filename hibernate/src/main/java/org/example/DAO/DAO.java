package org.example.DAO;

import java.util.List;

public interface DAO<T> {
    T get(Integer id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);
}