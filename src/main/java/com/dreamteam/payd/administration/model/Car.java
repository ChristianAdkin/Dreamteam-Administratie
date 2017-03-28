package com.dreamteam.payd.administration.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
@Entity
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ICAN;
    @NotNull
    private String VIN;
    private String licenceplate;
    @OneToMany
    private List<Ownership> ownerships;

    protected Car() {
    }

    public Car(String ICAN, String VIN, String licenceplate) {
        this.ICAN = ICAN;
        this.VIN = VIN;
        this.licenceplate = licenceplate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getICAN() {
        return ICAN;
    }

    public void setICAN(String ICAN) {
        this.ICAN = ICAN;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getLicenceplate() {
        return licenceplate;
    }

    public void setLicenceplate(String licenceplate) {
        this.licenceplate = licenceplate;
    }

    public List<Ownership> getOwnerships() {
        return Collections.unmodifiableList(ownerships);
    }

    public void setOwnerships(List<Ownership> ownerships) {
        this.ownerships = ownerships;
    }
}
