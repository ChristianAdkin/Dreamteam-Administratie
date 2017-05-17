package com.dreamteam.payd.administration.service.portal;

import com.dreamteam.payd.administration.model.Car;

import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
public interface TranslocationService {
    Car getCarById(Long id);
    List<Car> getAllCars();
}
