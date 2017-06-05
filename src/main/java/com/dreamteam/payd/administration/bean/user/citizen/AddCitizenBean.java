package com.dreamteam.payd.administration.bean.user.citizen;

import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Citizen;
import com.dreamteam.payd.administration.service.internal.DriverRegistrationService;
import com.dreamteam.payd.administration.service.internal.VehicleService;
import com.dreamteam.payd.administration.service.police.CarService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Christian Adkin on 09/05/2017.
 */
@Named
@ViewScoped
public class AddCitizenBean implements Serializable {

    @Inject
    private DriverRegistrationService driverRegistrationService;

    private String initials;
    private String firstName;
    private String preposition;
    private String lastName;

    public void init() {

        this.construct();
    }

    private void construct() {

    }

    public void save() {
        Citizen citizen = new Citizen("", this.firstName, this.lastName);
        citizen.setInitials(this.initials);
        citizen.setPreposition(this.preposition);

        driverRegistrationService.createCitizen(citizen);

        this.initials = null;
        this.firstName = null;
        this.preposition = null;
        this.lastName = null;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPreposition() {
        return preposition;
    }

    public void setPreposition(String preposition) {
        this.preposition = preposition;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
