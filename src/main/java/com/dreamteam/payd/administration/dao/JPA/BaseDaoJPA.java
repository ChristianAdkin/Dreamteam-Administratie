package com.dreamteam.payd.administration.dao.JPA;

import com.dreamteam.payd.administration.dao.BaseDao;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Christian Adkin on 08/03/2017.
 */
@Stateless
public abstract class BaseDaoJPA<T> implements BaseDao<T> {

    @PersistenceContext(name = "administrationPU")
    protected EntityManager entityManager;

    protected Class<T> entityClass;

    protected BaseDaoJPA() {
        //Some magic to get the entityClass.
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    /**
     * Persist an entity to the database.
     * @param entity the entity to create
     */
    public T create(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    /**
     * Update an entity in the database.
     * @param entity the entity to update
     * @return the updated entity
     */
    public T update(T entity) {
        return entityManager.merge(entity);
    }

    /**
     * Remove an entity from the database
     * @param entity the entity to remove
     */
    public void remove(T entity) {
        entityManager.remove(entity);
    }

    /**
     * Flush the EntityManager
     */
    public void flush() {
        entityManager.flush();
    }

    /**
     * Find an Entity of GenericType using their ID
     * @param id the id of the entity
     * @return the found entity
     */
    public T findById(Long id) {
        return entityManager.find(entityClass, id);
    }

    /**
     * Get all entities of GenericType
     * @return All entities of certain type.
     */
    public List<T> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> c = builder.createQuery(entityClass);
        c.from(entityClass);
        TypedQuery<T> query = entityManager.createQuery(c);
        return query.getResultList();
    }
}
