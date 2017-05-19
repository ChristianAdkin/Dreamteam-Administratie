package com.dreamteam.payd.administration.service.portal;

import com.dreamteam.payd.administration.dao.CarDao;
import com.dreamteam.payd.administration.model.Car;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Christian Adkin on 04/04/2017.
 */
@Stateless
public class TranslocationServiceImpl implements TranslocationService {

    @Inject
    private CarDao carDao;

    @Override
    public Car getCarById(Long id) {
        return carDao.findById(id);
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getAll();
    }

    @Override
    public List<Car> getCarsByUser(Long userId) {
        return this.carDao.getCarsByUser(userId);
    }
}