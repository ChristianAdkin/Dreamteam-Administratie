package com.dreamteam.payd.administration.dao.JPA;

import com.dreamteam.payd.administration.dao.CartrackerDao;
import com.dreamteam.payd.administration.dao.qualifier.JPA;
import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Cartracker;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Christian Adkin on 02/05/2017.
 */
@Stateless
public class CartrackerDaoJPA extends BaseDaoJPA<Cartracker> implements CartrackerDao {
    @Override
    public List<Cartracker> queryByICAN(String query) {
            List<Cartracker> cartrackers = entityManager.createQuery("SELECT c FROM Cartracker c WHERE c.ICAN LIKE :ICAN ", Cartracker.class).setParameter("ICAN", "%" + query + "%").getResultList();
            return cartrackers;
    }
}
