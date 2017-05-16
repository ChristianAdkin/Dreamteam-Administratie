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
public class Route implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Day day;

    @Column(precision = 20, scale = 10)
    private BigDecimal price;

    private Long distance;

    @OneToMany
    private List<Region> regions;

    protected Route() {
        this.regions = new ArrayList<>();
    }

    public Route(Day day) {
        this();
        this.day = day;
    }

    public Long getId() {
        return id;
    }
}
