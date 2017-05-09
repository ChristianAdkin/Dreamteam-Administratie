package com.dreamteam.payd.administration.bean.user.ownership;

import com.dreamteam.payd.administration.model.Citizen;
import com.dreamteam.payd.administration.model.Ownership;
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
public class OwnershipOverviewBean implements Serializable {
    @Inject
    private CarService carService;

    private List<Ownership> ownerships;

    public void init() {
        this.ownerships = carService.getAllOwnerships();

        this.construct();
    }

    private void construct() {

    }

    public List<Ownership> getOwnerships() {
        return ownerships;
    }

    public void setOwnerships(List<Ownership> ownerships) {
        this.ownerships = ownerships;
    }
}
