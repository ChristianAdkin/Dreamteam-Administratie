package com.dreamteam.payd.administration.bean.user.cartracker;

import com.dreamteam.payd.administration.model.Cartracker;
import com.dreamteam.payd.administration.service.police.CarService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Christian Adkin on 02/05/2017.
 */
@Named
@ViewScoped
public class CartrackerOverviewBean implements Serializable {

    @Inject
    private CarService carService;

    private List<Cartracker> cartrackers;

    public void init() {
        this.cartrackers = carService.getAllCartrackers();

        this.construct();
    }

    private void construct() {

    }

    public List<Cartracker> getCartrackers() {
        return cartrackers;
    }

    public void setCartrackers(List<Cartracker> cartrackers) {
        this.cartrackers = cartrackers;
    }
}
