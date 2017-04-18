package com.dreamteam.payd.administration.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
@Entity
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus invoiceStatus;

    @ManyToOne
    private Citizen citizen;
    @ManyToOne
    private Car car;

    @OneToMany
    private List<InvoiceLine> invoiceLines;

    protected Invoice() {
        this.invoiceLines = new ArrayList<>();
    }

    public Invoice(Citizen citizen, Car car) {
        this();
        this.citizen = citizen;
        this.car = car;
    }

    public Invoice(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (InvoiceLine invoiceLine : invoiceLines) {
            totalPrice = totalPrice.add(invoiceLine.getPrice());
        }
        return totalPrice;
    }
}
