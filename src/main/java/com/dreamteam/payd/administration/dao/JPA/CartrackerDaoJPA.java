package com.dreamteam.payd.administration.dao.JPA;

import com.dreamteam.payd.administration.dao.CartrackerDao;
import com.dreamteam.payd.administration.dao.qualifier.JPA;
import com.dreamteam.payd.administration.model.Cartracker;

import javax.ejb.Stateless;

/**
 * Created by Christian Adkin on 02/05/2017.
 */
@Stateless
public class CartrackerDaoJPA extends BaseDaoJPA<Cartracker> implements CartrackerDao {
}
