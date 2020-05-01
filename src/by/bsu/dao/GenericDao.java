package by.bsu.dao;

import java.util.List;
import java.util.Set;


public interface GenericDao<T> {
    T create(T entity);
    void delete(Long id);
    T findById(Long id);
    Set<T> findAll();

}


