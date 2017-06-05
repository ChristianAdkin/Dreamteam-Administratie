package com.dreamteam.payd.administration.bean.user.car;

import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Cartracker;
import com.dreamteam.payd.administration.model.FuelType;
import com.dreamteam.payd.administration.service.internal.VehicleService;
import com.dreamteam.payd.administration.service.police.CarService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Christian Adkin on 09/05/2017.
 */
@Named
@ViewScoped
public class AddCarBean implements Serializable {

    @Inject
    private VehicleService vehicleService;

    private String licenceplate;
    private String VIN;

    private FuelType fuelType;
    private String colour;

    public void init() {
        this.construct();
    }

    private void construct() {

    }

    public void save() {
        //TODO: Validate input

        Car car = new Car(this.licenceplate, this.VIN);
        this.vehicleService.createCar(car);
        car.setFuelType(this.fuelType);
        car.setColour(this.colour);

        this.licenceplate = null;
        this.VIN = null;

        this.fuelType = null;
        this.colour = null;
    }

    public FuelType[] getFuelTypeValues() {
        return FuelType.values();
    }

    public String getLicenceplate() {
        return licenceplate;
    }

    public void setLicenceplate(String licenceplate) {
        this.licenceplate = licenceplate;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
