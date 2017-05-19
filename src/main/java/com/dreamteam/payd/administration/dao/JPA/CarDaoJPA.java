package com.dreamteam.payd.administration.dao.JPA;

import com.dreamteam.payd.administration.dao.CarDao;
import com.dreamteam.payd.administration.dao.qualifier.JPA;
import com.dreamteam.payd.administration.model.Car;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
@Stateless
public class CarDaoJPA extends BaseDaoJPA<Car> implements CarDao {

    @Override
    public List<Car> findByICAN(String ICAN) {
        return entityManager.createQuery("SELECT c FROM Car c WHERE c.cartracker.ICAN = :ICAN ", Car.class).setParameter("ICAN", ICAN).getResultList();
    }
}
