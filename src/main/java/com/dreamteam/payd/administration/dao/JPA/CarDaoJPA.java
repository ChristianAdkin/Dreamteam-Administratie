package com.dreamteam.payd.administration.dao.JPA;

import com.dreamteam.payd.administration.api.portal.DTO.CoordinateDTO;
import com.dreamteam.payd.administration.dao.CarDao;
import com.dreamteam.payd.administration.dao.qualifier.JPA;
import com.dreamteam.payd.administration.model.Car;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.ArrayList;
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

    @Override
    public List<Car> getCarsByUser(Long userId) {
        List<Car> cars = new ArrayList<>();
        try {
            cars = entityManager.createQuery("SELECT c FROM Car c WHERE c.id IN (SELECT o.owned.id FROM Ownership o WHERE o.owner.user.id = :userId AND o.endOwnership IS NULL)", Car.class)
                    .setParameter("userId", userId)
                    .getResultList();
        } catch (PersistenceException ex) {
            ex.printStackTrace();
        }
        return cars;
    }

    @Override
    public Long getAmountOfDrivenKmTodayOfUser(Long userId) {
        throw new NotImplementedException();
    }

    @Override
    public List<Car> queryByVIN(String query) {
        List<Car> cars = entityManager.createQuery("SELECT c FROM Car c WHERE c.VIN LIKE :VIN ", Car.class).setParameter("VIN", "%" + query + "%").getResultList();
        return cars;
    }
}
