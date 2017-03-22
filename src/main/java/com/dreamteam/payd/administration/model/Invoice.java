package com.dreamteam.payd.administration.model;

import javax.persistence.*;
import java.io.Serializable;
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

    @OneToMany
    private List<InvoiceLine> invoiceLines;

    public Invoice() {
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
}
