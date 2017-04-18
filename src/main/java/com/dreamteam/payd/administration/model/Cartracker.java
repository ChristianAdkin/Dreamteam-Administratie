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

    @ManyToOne
    private Day day;

    @ManyToOne
    private Car car;

    protected Cartracker() {

    }

    public Cartracker(Car car) {
        this();
        this.car = car;
    }

    public Long getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
