package com.dreamteam.payd.administration.bean.jms.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by hein on 6/2/17.
 */
public class InvoiceLineDto {

    private String ICAN;
    private BigDecimal price;
    private Date dateOfInvoice;
    private List<InvoiceRouteDto> routes;
    private double distance;

    public InvoiceLineDto() {
    }

    public String getICAN() {
        return ICAN;
    }

    public void setICAN(String ICAN) {
        this.ICAN = ICAN;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDateOfInvoice() {
        return dateOfInvoice;
    }

    public void setDateOfInvoice(Date dateOfInvoice) {
        this.dateOfInvoice = dateOfInvoice;
    }

    public List<InvoiceRouteDto> getRoutes() {
        return routes;
    }

    public void setRoutes(List<InvoiceRouteDto> routes) {
        this.routes = routes;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
