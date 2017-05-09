package com.dreamteam.payd.administration.bean.user.citizen;

import com.dreamteam.payd.administration.model.Cartracker;
import com.dreamteam.payd.administration.model.Citizen;
import com.dreamteam.payd.administration.service.police.CarService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Christian Adkin on 09/05/2017.
 */
@Named
@ViewScoped
public class CitizenOverviewBean implements Serializable{

    @Inject
    private CarService carService;

    private List<Citizen> citizens;

    public void init() {
        this.citizens = carService.getAllCitizens();

        this.construct();
    }

    private void construct() {

    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }
}
