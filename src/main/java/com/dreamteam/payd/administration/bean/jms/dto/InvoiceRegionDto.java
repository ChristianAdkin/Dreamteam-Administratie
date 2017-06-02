package com.dreamteam.payd.administration.bean.jms.dto;

import java.math.BigDecimal;

/**
 * Created by hein on 6/2/17.
 */
public class InvoiceRegionDto {

    private String areaCode;
    private String name;
    private BigDecimal price;
    private Double distance;

    public InvoiceRegionDto() {
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
