package com.dreamteam.payd.administration.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
@Entity
public class InvoiceLine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 20, scale = 10)
    private BigDecimal price;

    @ManyToOne
    private Invoice invoice;

    @OneToOne
    private Day day;

    private double distance;

    private String ICAN;

    public InvoiceLine() {
    }

    public InvoiceLine(BigDecimal price, Invoice invoice) {
        this.price = price;
        this.invoice = invoice;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
        day.setInvoiceLine(this);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getICAN() {
        return ICAN;
    }

    public void setICAN(String ICAN) {
        this.ICAN = ICAN;
    }
}
