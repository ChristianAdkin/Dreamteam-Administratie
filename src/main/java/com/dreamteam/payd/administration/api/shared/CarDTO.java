package com.dreamteam.payd.administration.api.shared;

import com.dreamteam.payd.administration.model.FuelType;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public class CarDTO {

    private Long id;
    private String licensePlate;
    private String vin;
    private String ican;
    private FuelType fuelType;
    private String vehicleColor;

    public CarDTO() {

    }

    public CarDTO(Long id, String licensePlate, String vin, String ican, FuelType fuelType, String vehicleColor) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.vin = vin;
        this.ican = ican;
        this.fuelType = fuelType;
        this.vehicleColor = vehicleColor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getIcan() {
        return ican;
    }

    public void setIcan(String ican) {
        this.ican = ican;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }
}
