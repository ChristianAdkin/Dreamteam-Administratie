package com.dreamteam.payd.administration.bean.user.car;

import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Cartracker;
import com.dreamteam.payd.administration.model.Region;
import com.dreamteam.payd.administration.service.internal.VehicleService;
import com.dreamteam.payd.administration.service.police.CarService;
import com.dreamteam.payd.administration.util.ContextUtil;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Adkin on 09/05/2017.
 */
@Named
@ViewScoped
public class CarOverviewBean implements Serializable {
    @Inject
    private VehicleService vehicleService;

    private List<Car> queriedCars;
    private String query;

    public void init() {
        if (!ContextUtil.isAjaxRequest(FacesContext.getCurrentInstance())) {
            this.construct();
        }
    }

    private void construct() {
        this.queriedCars = new ArrayList<>();
    }

    public List<Car> findMatchingCar() {
        if (query.length() < 4) {
            return this.queriedCars;
        }
        this.queriedCars = vehicleService.queryCarsByVIN(query);
        return this.queriedCars;
    }

    public List<Car> getQueriedCars() {
        return queriedCars;
    }

    public void setQueriedCars(List<Car> queriedCars) {
        this.queriedCars = queriedCars;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
