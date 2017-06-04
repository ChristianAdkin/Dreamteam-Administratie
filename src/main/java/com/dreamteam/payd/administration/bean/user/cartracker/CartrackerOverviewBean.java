package com.dreamteam.payd.administration.bean.user.cartracker;

import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Cartracker;
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
 * Created by Christian Adkin on 02/05/2017.
 */
@Named
@ViewScoped
public class CartrackerOverviewBean implements Serializable {

    @Inject
    private VehicleService vehicleService;

    private List<Cartracker> queriedCartrackers;
    private String query;

    public void init() {
        if (!ContextUtil.isAjaxRequest(FacesContext.getCurrentInstance())) {
            this.construct();
        }
    }

    private void construct() {
        this.queriedCartrackers = new ArrayList<>();
    }

    public List<Cartracker> findMatchingCartracker() {
        if (query.length() < 4) {
            return this.queriedCartrackers;
        }
        this.queriedCartrackers = vehicleService.queryCartrackersByICAN(query);
        return this.queriedCartrackers;
    }

    public List<Cartracker> getQueriedCartrackers() {
        return queriedCartrackers;
    }

    public void setQueriedCartrackers(List<Cartracker> queriedCartrackers) {
        this.queriedCartrackers = queriedCartrackers;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
