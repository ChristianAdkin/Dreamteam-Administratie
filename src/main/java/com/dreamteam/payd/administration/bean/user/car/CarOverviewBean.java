package com.dreamteam.payd.administration.bean.user.car;

import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Cartracker;
import com.dreamteam.payd.administration.service.police.CarService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Christian Adkin on 09/05/2017.
 */
@Named
@ViewScoped
public class CarOverviewBean implements Serializable {
    @Inject
    private CarService carService;

    private List<Car> cars;

    public void init() {
        this.cars = carService.getAllCars();

        this.construct();
    }

    private void construct() {

    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
