package com.dreamteam.payd.administration.dao.JPA;

import com.dreamteam.payd.administration.dao.CitizenDao;
import com.dreamteam.payd.administration.model.Citizen;

import javax.ejb.Stateless;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
@Stateless
public class CitizenDaoJPA extends BaseDaoJPA<Citizen> implements CitizenDao {
    @Override
    public Citizen findByEmail(String email) {
        return getSingleResult(entityManager.createQuery("SELECT c FROM Citizen c WHERE c.user.emailAddress = :email", Citizen.class).setParameter("email", email).getResultList());
    }
}
