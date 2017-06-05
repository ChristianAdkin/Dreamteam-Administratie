package com.dreamteam.payd.administration.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Adkin on 18/04/2017.
 */
@Entity
public class Route implements Serializable, Comparable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Day day;

    @Column(precision = 20, scale = 10)
    private BigDecimal price;

    private double distance;

    @OneToMany(cascade = CascadeType.ALL)
    private List<InvoiceRegion> invoiceRegions;

    protected Route() {
        this.invoiceRegions = new ArrayList<>();
    }

    public Route(Day day) {
        this();
        this.day = day;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public BigDecimal getPrice() {
        return price;
    }

    public Day getDay() { return day; }

    public double getDistance() { return this.distance; }

    @Override
    public int compareTo(Object o) {
        Route routeToCompare = (Route) o;
        if (routeToCompare.getDay().getDayDate().after(this.day.getDayDate())) {
            return 1;
        } else if (routeToCompare.getDay().getDayDate().before(this.day.getDayDate())){
            return -1;
        }
        return 0;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<InvoiceRegion> getInvoiceRegions() {
        return invoiceRegions;
    }

    public void setInvoiceRegions(List<InvoiceRegion> invoiceRegions) {
        this.invoiceRegions = invoiceRegions;
    }
}
