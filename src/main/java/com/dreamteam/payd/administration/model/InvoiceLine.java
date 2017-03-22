package com.dreamteam.payd.administration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
@Entity
public class InvoiceLine implements Serializable {

    @Id
    private Long id;

    public InvoiceLine() {
    }

    public InvoiceLine(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
