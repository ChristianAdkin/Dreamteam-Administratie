package com.dreamteam.payd.administration.service.internal;

import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Cartracker;
import com.dreamteam.payd.administration.model.Citizen;
import com.dreamteam.payd.administration.model.Ownership;

import java.util.List;

/**
 * Created by Christian Adkin on 02/06/2017.
 */
public interface VehicleService {
    /**
     * Retrieve all Car objects from the database.
     *
     * @return A list of all Car objects.
     */
    List<Car> getAllCars();

    List<Car> queryCarsByVIN(String query);

    void createCar(Car car);

    void createCartracker(Cartracker cartracker);

    Car updateCar(Car car);

    List<Cartracker> queryCartrackersByICAN(String query);

    Car findCarById(Long carId);

    List<Car> findCarByICAN(String ICAN);
}
