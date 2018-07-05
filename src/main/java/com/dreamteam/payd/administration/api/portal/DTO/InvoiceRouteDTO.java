package com.dreamteam.payd.administration.api.portal.DTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public class InvoiceRouteDTO {

    private Long id;
    private double totalprice;

    private Date starttime;
    private Date endtime;

    private double drivenkm;

    public InvoiceRouteDTO(Long id, double totalprice, Date starttime, Date endtime, double drivenkm) {
        this.id = id;
        this.totalprice = totalprice;
        this.starttime = starttime;
        this.endtime = endtime;
        this.drivenkm = drivenkm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStarttime() {
        return starttime;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public double getDrivenkm() {
        return drivenkm;
    }

    public void setDrivenkm(double drivenkm) {
        this.drivenkm = drivenkm;
    }
}
