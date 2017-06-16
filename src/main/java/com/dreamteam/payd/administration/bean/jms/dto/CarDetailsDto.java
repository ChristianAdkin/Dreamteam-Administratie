package com.dreamteam.payd.administration.bean.jms.dto;

import com.dreamteam.payd.administration.model.FuelType;

/**
 * Created by hein on 6/13/17.
 */
public class CarDetailsDto {

    private String ICAN;
    private String licenceplate;
    private FuelType fuelType;
    private String colour;

    public CarDetailsDto() {
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
