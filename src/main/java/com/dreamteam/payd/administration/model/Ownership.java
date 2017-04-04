package com.dreamteam.payd.administration.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Christian Adkin on 28/03/2017.
 */
@Entity
public class Ownership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Citizen owner;
    @ManyToOne
    private Car owned;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date startOwnership;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date endOwnership;

    public Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    public Citizen getOwner() {
        return owner;
    }

    public void setOwner(Citizen owner) {
        this.owner = owner;
    }

    public Car getOwned() {
        return owned;
    }

    public void setOwned(Car owned) {
        this.owned = owned;
    }

    public Date getStartOwnership() {
        return startOwnership;
    }

    public void setStartOwnership(Date startOwnership) {
        this.startOwnership = startOwnership;
    }

    public Date getEndOwnership() {
        return endOwnership;
    }

    public void setEndOwnership(Date endOwnership) {
        this.endOwnership = endOwnership;
    }
}
