package com.dreamteam.payd.administration.bean.user.car;

import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.service.internal.VehicleService;
import com.dreamteam.payd.administration.util.ContextUtil;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Christian Adkin on 04/06/2017.
 */
@Named
@ViewScoped
public class SelectedCarBean implements Serializable {

    @Inject
    private VehicleService vehicleService;

    private Long carId;
    private Car car;

    public void init() {
        if (!ContextUtil.isAjaxRequest(FacesContext.getCurrentInstance())) {
            this.car = vehicleService.findCarById(carId);
            this.construct();
        }
    }

    private void construct() {

    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
