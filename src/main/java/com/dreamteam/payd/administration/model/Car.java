package com.dreamteam.payd.administration.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
@Entity
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String VIN;
    private String licenceplate;

    private FuelType fuelType;

    private String colour;

    @Enumerated(EnumType.STRING)
    private CarStatus carStatus;
    private String comments;

    @OneToOne
    private Cartracker cartracker;

    protected Car() {
    }

    public Car(String VIN, String licenceplate) {
        this.VIN = VIN;
        this.licenceplate = licenceplate;
        this.carStatus = CarStatus.DEFAULT;
        this.comments = "";
    }

    public Car(String VIN, String licenceplate, FuelType fuelType, String colour) {
        this(VIN, licenceplate);
        this.fuelType = fuelType;
        this.colour = colour;
        this.carStatus = CarStatus.DEFAULT;
        this.comments = "";
    }

    @Override
    public String toString() {
        return this.id + " - Licenceplate: " + this.licenceplate + " - VIN: " +  this.VIN;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Cartracker getCartracker() {
        return cartracker;
    }

    public void setCartracker(Cartracker cartracker) {
        this.cartracker = cartracker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return id != null ? id.equals(car.id) : car.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
