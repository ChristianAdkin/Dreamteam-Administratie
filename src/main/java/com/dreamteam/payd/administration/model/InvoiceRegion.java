package com.dreamteam.payd.administration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Christian Adkin on 06/06/2017.
 */
@Entity
public class InvoiceRegion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String areaCode;
    private String name;
    private BigDecimal price;
    private Double distance;

    protected InvoiceRegion () {

    }

    public InvoiceRegion(String areaCode, String name, BigDecimal price, Double distance) {
        this.areaCode = areaCode;
        this.name = name;
        this.price = price;
        this.distance = distance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Double getDistance() {
        return distance;
    }
}
