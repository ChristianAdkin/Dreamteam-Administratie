package com.dreamteam.payd.administration.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Christian Adkin on 18/04/2017.
 */
@Entity
public class Day implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dayDate;

    @OneToMany
    private List<Route> routes;

    public Day() {
        this.dayDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public Date getDayDate() {
        return dayDate;
    }
}
