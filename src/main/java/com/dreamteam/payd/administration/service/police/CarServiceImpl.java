package com.dreamteam.payd.administration.service.police;

import com.dreamteam.payd.administration.dao.CarDao;
import com.dreamteam.payd.administration.dao.CartrackerDao;
import com.dreamteam.payd.administration.dao.qualifier.JPA;
import com.dreamteam.payd.administration.model.Cartracker;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Christian Adkin on 04/04/2017.
 */
@Stateless
public class CarServiceImpl implements CarService {

    @Inject
    private CarDao carDao;

    @Inject
    private CartrackerDao cartrackerDao;


    @Override
    public List<Cartracker> getAllCartrackers() {
        return cartrackerDao.getAll();
    }
}
