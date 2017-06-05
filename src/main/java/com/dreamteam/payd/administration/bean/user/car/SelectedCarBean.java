package com.dreamteam.payd.administration.bean.user.car;

import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Citizen;
import com.dreamteam.payd.administration.model.FuelType;
import com.dreamteam.payd.administration.model.Ownership;
import com.dreamteam.payd.administration.service.internal.DriverRegistrationService;
import com.dreamteam.payd.administration.service.internal.VehicleService;
import com.dreamteam.payd.administration.util.ContextUtil;
import org.primefaces.context.PrimeFacesContext;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.security.acl.Owner;

/**
 * Created by Christian Adkin on 04/06/2017.
 */
@Named
@ViewScoped
public class SelectedCarBean implements Serializable {


    @Inject
    private DriverRegistrationService driverRegistrationService;
    @Inject
    private VehicleService vehicleService;

    private Long carId;
    private Car car;
    private Citizen citizen;
    private Ownership ownership;

    public void init() {
        if (!ContextUtil.isAjaxRequest(FacesContext.getCurrentInstance())) {
            this.car = vehicleService.findCarById(carId);
            this.construct();
        }
    }

    private void construct() {
        this.citizen = this.driverRegistrationService.getCitizenByCar(car);
        this.ownership = this.driverRegistrationService.getOwnershipByCar(car);
    }

    public void save() {
        this.car = vehicleService.updateCar(car);
    }

    public FuelType[] getFuelTypes() {
        return FuelType.values();
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

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public Ownership getOwnership() {
        return ownership;
    }

    public void setOwnership(Ownership ownership) {
        this.ownership = ownership;
    }
}
