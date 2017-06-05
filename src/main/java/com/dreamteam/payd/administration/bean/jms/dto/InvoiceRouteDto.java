package com.dreamteam.payd.administration.bean.jms.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by hein on 6/2/17.
 */
public class InvoiceRouteDto {

    private Long routeId;
    private double distance;
    private BigDecimal price;
    private List<InvoiceRegionDto> drivenInRegions;

    public InvoiceRouteDto() {
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<InvoiceRegionDto> getDrivenInRegions() {
        return drivenInRegions;
    }

    public void setDrivenInRegions(List<InvoiceRegionDto> drivenInRegions) {
        this.drivenInRegions = drivenInRegions;
    }
}
