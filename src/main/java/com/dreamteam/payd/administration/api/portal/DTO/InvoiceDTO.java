package com.dreamteam.payd.administration.api.portal.DTO;

import com.dreamteam.payd.administration.model.InvoiceStatus;

import java.util.Date;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public class InvoiceDTO {
    private Long id;
    private Date date;
    private Long totalPrice;
    private InvoiceStatus status;

    public InvoiceDTO(Long id, Date date, Long totalPrice, InvoiceStatus status) {
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
        this.status = status;
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

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }
}
