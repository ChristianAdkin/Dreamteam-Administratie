package com.dreamteam.payd.administration.bean.user.citizen;

import com.dreamteam.payd.administration.model.Cartracker;
import com.dreamteam.payd.administration.model.Citizen;
import com.dreamteam.payd.administration.service.internal.DriverRegistrationService;
import com.dreamteam.payd.administration.service.internal.VehicleService;
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
    private DriverRegistrationService driverRegistrationService;

    private List<Citizen> queriedCitizens;
    private String query;

    public void init() {
        this.construct();
    }

    private void construct() {

    }

    public List<Citizen> findMatchingCitizens() {
        if (query.length() < 4) {
            return this.queriedCitizens;
        }
        this.queriedCitizens = driverRegistrationService.queryCitizensByDetails(query);
        return this.queriedCitizens;
    }

    public List<Citizen> getQueriedCitizens() {
        return queriedCitizens;
    }

    public void setQueriedCitizens(List<Citizen> queriedCitizens) {
        this.queriedCitizens = queriedCitizens;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
