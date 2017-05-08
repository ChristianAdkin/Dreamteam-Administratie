package com.dreamteam.payd.administration.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Adkin on 18/04/2017.
 */
@Entity
public class Pathway implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(precision = 20, scale = 10)
    private BigDecimal price;

    private Long distance;

    @ManyToOne
    private Route route;

    @OneToMany
    private List<Region> regions;

    protected Pathway() {
        this.regions = new ArrayList<>();
    }

    public Pathway(String name) {
        this();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

}
