package com.dreamteam.payd.administration.bean.user.cartracker;

import com.dreamteam.payd.administration.model.Cartracker;
import com.dreamteam.payd.administration.model.Citizen;
import com.dreamteam.payd.administration.service.internal.VehicleService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Christian Adkin on 04/06/2017.
 */
@Named
@ViewScoped
public class AddCartrackerBean implements Serializable {

    @Inject
    private VehicleService vehicleService;

    private String ICAN;

    public void init() {
        this.construct();
    }

    private void construct() {

    }

    public void save() {
        Cartracker cartracker = new Cartracker(this.ICAN);
        vehicleService.createCartracker(cartracker);

        this.ICAN = null;
    }

    public String getICAN() {
        return ICAN;
    }

    public void setICAN(String ICAN) {
        this.ICAN = ICAN;
    }
}
