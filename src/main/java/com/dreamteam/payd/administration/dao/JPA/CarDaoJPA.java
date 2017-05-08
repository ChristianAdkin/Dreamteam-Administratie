package com.dreamteam.payd.administration.dao.JPA;

import com.dreamteam.payd.administration.dao.CarDao;
import com.dreamteam.payd.administration.dao.qualifier.JPA;
import com.dreamteam.payd.administration.model.Car;

import javax.ejb.Stateless;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
@Stateless
public class CarDaoJPA extends BaseDaoJPA<Car> implements CarDao {

}
