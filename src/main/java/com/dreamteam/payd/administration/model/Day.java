package com.dreamteam.payd.administration.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
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

    private Long distance;

    @OneToOne
    private InvoiceLine invoiceLine;

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

    public void setDayDate(Date day) { this.dayDate = day; }

    public List<Route> getRoutes() {
        return Collections.unmodifiableList(this.routes);
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public BigDecimal getTotalPrice() {
        return invoiceLine.getPrice();
    }


    public void setInvoiceLine(InvoiceLine invoiceLine) {
        this.invoiceLine = invoiceLine;
    }
}
