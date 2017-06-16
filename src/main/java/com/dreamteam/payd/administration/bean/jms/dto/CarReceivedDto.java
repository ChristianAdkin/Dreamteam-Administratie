package com.dreamteam.payd.administration.bean.jms.dto;

/**
 * Created by hein on 6/13/17.
 */
public class CarReceivedDto {

    private String VIN;
    private String licenceplate;
    private String fuelType;
    private String colour;

    public CarReceivedDto() {
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getLicenceplate() {
        return licenceplate;
    }

    public void setLicenceplate(String licenceplate) {
        this.licenceplate = licenceplate;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
