package com.dreamteam.payd.administration.dao.JPA;

import com.dreamteam.payd.administration.dao.OwnershipDao;
import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Citizen;
import com.dreamteam.payd.administration.model.Ownership;

import java.util.List;

/**
 * Created by Christian Adkin on 05/05/2017.
 */
public class OwnershipDaoJPA extends BaseDaoJPA<Ownership> implements OwnershipDao {
    @Override
    public Ownership getCurrentOwnershipByCar(Car car) {
        return getSingleResult(entityManager.createQuery("SELECT o FROM Ownership o WHERE o.owned = :car AND o.endOwnership IS NULL", Ownership.class)
                .setParameter("car", car)
                .getResultList());
    }

    @Override
    public List<Ownership> getCurrentOwnershipsByCitizen(Citizen citizen) {
        return entityManager.createQuery("SELECT o FROM Ownership o WHERE o.owner = :citizen AND o.endOwnership IS NULL", Ownership.class)
                .setParameter("citizen", citizen)
                .getResultList();
    }

    @Override
    public List<Ownership> getPastOwnershipsByCitizen(Citizen citizen) {
        return entityManager.createQuery("SELECT o FROM Ownership o WHERE o.owner = :citizen AND o.endOwnership IS NOT NULL", Ownership.class)
                .setParameter("citizen", citizen)
                .getResultList();
    }
}
