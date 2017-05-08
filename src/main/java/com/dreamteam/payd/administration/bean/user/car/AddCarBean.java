package com.dreamteam.payd.administration.bean.user.car;

import com.dreamteam.payd.administration.model.Car;
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
    private CarService carService;

    private String ICAN;
    private String licenceplate;
    private String VIN;

    public void init() {

        this.construct();
    }

    private void construct() {

    }

    public void save() {
        Car car = new Car(this.ICAN, this.licenceplate, this.VIN);
        this.carService.create(car);

        this.ICAN = null;
        this.licenceplate = null;
        this.VIN = null;
    }

    public String getICAN() {
        return ICAN;
    }

    public void setICAN(String ICAN) {
        this.ICAN = ICAN;
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
}
