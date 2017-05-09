package com.dreamteam.payd.administration.bean.user.ownership;

import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Citizen;
import com.dreamteam.payd.administration.model.Ownership;
import com.dreamteam.payd.administration.service.police.CarService;
import com.dreamteam.payd.administration.util.ContextUtil;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Christian Adkin on 09/05/2017.
 */
@Named
@ViewScoped
public class AddOwnershipBean implements Serializable {

    @Inject
    private CarService carService;

    private List<Car> cars;
    private Car selectedCar;

    private List<Citizen> citizens;
    private Citizen selectedCitizen;

    public void init() {
        if (!ContextUtil.isAjaxRequest(FacesContext.getCurrentInstance())) {
            this.construct();
        }
    }

    private void construct() {
        this.cars = carService.getAllCars();
        this.citizens = carService.getAllCitizens();
    }

    public void save() {
        Ownership ownership = new Ownership(selectedCitizen, selectedCar, new Date());
        carService.create(ownership);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }

    public Citizen getSelectedCitizen() {
        return selectedCitizen;
    }

    public void setSelectedCitizen(Citizen selectedCitizen) {
        this.selectedCitizen = selectedCitizen;
    }
}
