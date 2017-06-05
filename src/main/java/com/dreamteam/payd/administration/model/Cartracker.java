package com.dreamteam.payd.administration.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Christian Adkin on 18/04/2017.
 */
@Entity
public class Cartracker implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ICAN;

    @ManyToOne
    private Day day;

    @OneToOne
    private Car car;

    protected Cartracker() {

    }

    public Cartracker(String ICAN) {
        this();
        this.ICAN = ICAN;
    }

    public Cartracker(Car car, String ICAN) {
        this(ICAN);
        this.setCar(car);
    }

    public Long getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
        this.car.setCartracker(this);
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public String getICAN() {
        return ICAN;
    }

    public void setICAN(String ICAN) {
        this.ICAN = ICAN;
    }
}
