package com.dreamteam.payd.administration.bean.user.citizen;

import com.dreamteam.payd.administration.model.Citizen;
import com.dreamteam.payd.administration.service.internal.DriverRegistrationService;
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
public class SelectedCitizenBean implements Serializable {

    @Inject
    private DriverRegistrationService driverRegistrationService;

    private Long citizenId;
    private Citizen citizen;

    public void init() {
        if (!ContextUtil.isAjaxRequest(FacesContext.getCurrentInstance())) {
            this.citizen = driverRegistrationService.findCitizenById(citizenId);
            this.construct();
        }
    }

    private void construct() {

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
}
