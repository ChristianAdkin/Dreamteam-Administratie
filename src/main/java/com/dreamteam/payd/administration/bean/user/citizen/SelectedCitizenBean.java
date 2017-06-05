package com.dreamteam.payd.administration.bean.user.citizen;

import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Citizen;
import com.dreamteam.payd.administration.model.Ownership;
import com.dreamteam.payd.administration.service.internal.DriverRegistrationService;
import com.dreamteam.payd.administration.service.internal.VehicleService;
import com.dreamteam.payd.administration.util.ContextUtil;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Christian Adkin on 04/06/2017.
 */
@Named
@ViewScoped
public class SelectedCitizenBean implements Serializable {

    @Inject
    private DriverRegistrationService driverRegistrationService;
    @Inject
    private VehicleService vehicleService;

    private Long citizenId;
    private Citizen citizen;
    private List<Ownership> currentOwnerships;
    private List<Ownership> pastOwnerships;
    private List<Car> cars;

    public void init() {
        if (!ContextUtil.isAjaxRequest(FacesContext.getCurrentInstance())) {
            this.citizen = driverRegistrationService.findCitizenById(citizenId);
            this.construct();
        }
    }

    private void construct() {
        this.currentOwnerships = driverRegistrationService.getOwnershipsByCitizen(this.citizen);
        this.pastOwnerships = driverRegistrationService.getPastOwnershipsByCitizen(this.citizen);
        this.cars = driverRegistrationService.getCarsByCitizen(this.citizen);
    }

    public void save() {
        this.citizen = driverRegistrationService.updateCitizen(this.citizen);
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public List<Ownership> getCurrentOwnerships() {
        return currentOwnerships;
    }

    public void setCurrentOwnerships(List<Ownership> currentOwnerships) {
        this.currentOwnerships = currentOwnerships;
    }

    public List<Ownership> getPastOwnerships() {
        return pastOwnerships;
    }

    public void setPastOwnerships(List<Ownership> pastOwnerships) {
        this.pastOwnerships = pastOwnerships;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
