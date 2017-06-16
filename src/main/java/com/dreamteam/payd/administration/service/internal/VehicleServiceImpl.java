package com.dreamteam.payd.administration.service.internal;

import com.dreamteam.payd.administration.dao.CarDao;
import com.dreamteam.payd.administration.dao.CartrackerDao;
import com.dreamteam.payd.administration.dao.CitizenDao;
import com.dreamteam.payd.administration.dao.OwnershipDao;
import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Cartracker;
import com.dreamteam.payd.administration.model.Citizen;
import com.dreamteam.payd.administration.model.Ownership;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Christian Adkin on 02/06/2017.
 */
@Stateless
public class VehicleServiceImpl implements VehicleService {
    @Inject
    private CarDao carDao;
    @Inject
    private CartrackerDao cartrackerDao;
    @Inject
    private CitizenDao citizenDao;
    @Inject
    private OwnershipDao ownershipDao;

    public List<Car> getAllCars() {
        return carDao.getAll();
    }

    @Override
    public List<Car> queryCarsByVIN(String query) {
        return carDao.queryByVIN(query);
    }

    @Override
    public void createCar(Car car) {
        this.carDao.create(car);
    }

    @Override
    public void createCartracker(Cartracker cartracker) {
        this.cartrackerDao.create(cartracker);
    }

    @Override
    public Car updateCar(Car car) {
        return this.carDao.update(car);
    }

    @Override
    public List<Cartracker> queryCartrackersByICAN(String query) {
        return this.cartrackerDao.queryByICAN(query);
    }

    @Override
    public Car findCarById(Long carId) {
        return this.carDao.findById(carId);
    }

    @Override
    public List<Car> findCarByICAN(String ICAN) {
        return this.carDao.findByICAN(ICAN);
    }

}
