package com.dreamteam.payd.administration.dao;

import java.util.List;

/**
 * Created by Christian Adkin on 28/03/2017.
 */
public interface BaseDao<T> {

    void create(T entity);

    T update(T entity);

    void remove(T entity);

    void flush();

    T findById(Long id);

    List<T> getAll();
}
