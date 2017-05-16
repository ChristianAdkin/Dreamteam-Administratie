package com.dreamteam.payd.administration.api.portal.DTO;

import java.util.Date;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public class InvoiceDayDTO {

    private Long id;
    private Date date;
    private Long totalPrice;
    private int drivenkm;

    public InvoiceDayDTO(Long id, Date date, Long totalPrice, int drivenkm) {
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
        this.drivenkm = drivenkm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getDrivenkm() {
        return drivenkm;
    }

    public void setDrivenkm(int drivenkm) {
        this.drivenkm = drivenkm;
    }
}
