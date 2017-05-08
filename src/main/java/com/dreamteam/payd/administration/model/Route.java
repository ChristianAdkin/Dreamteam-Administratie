package com.dreamteam.payd.administration.model;

import javax.persistence.*;
import java.io.Serializable;
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

    @OneToMany
    private List<Pathway> pathways;

    public Route() {
        this.pathways = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }
}
