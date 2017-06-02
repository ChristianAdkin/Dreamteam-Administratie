package com.dreamteam.payd.administration.dao.JPA;

import com.dreamteam.payd.administration.dao.OwnershipDao;
import com.dreamteam.payd.administration.model.Ownership;

import javax.persistence.NoResultException;
import java.sql.SQLException;

/**
 * Created by Christian Adkin on 05/05/2017.
 */
public class OwnershipDaoJPA extends BaseDaoJPA<Ownership> implements OwnershipDao {

    @Override
    public Ownership findCurrentCarAndCitizenByIcan(String ICAN) {
        Ownership foundOwnership = null;
        try {
            foundOwnership = entityManager.createQuery("select o from Ownership o where o.endOwnership = null and o.owned.cartracker.ICAN = :ican", Ownership.class)
                    .setParameter("ican", ICAN)
                    .getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("No result found for ownerships with ICAN: " + ICAN);
        }
        return foundOwnership;
    }
}
