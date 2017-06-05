package com.dreamteam.payd.administration.api.portal.DTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public class InvoiceRouteDTO {

    private Long id;
    private Long totalprice;

    private Date starttime;
    private Date endtime;

    private Long drivenkm;

    public InvoiceRouteDTO(Long id, Long totalprice, Date starttime, Date endtime, Long drivenkm) {
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

    public Long getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Long totalprice) {
        this.totalprice = totalprice;
    }

    public Date getStarttime() {
        return starttime;
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

    public Long getDrivenkm() {
        return drivenkm;
    }

    public void setDrivenkm(Long drivenkm) {
        this.drivenkm = drivenkm;
    }
}
