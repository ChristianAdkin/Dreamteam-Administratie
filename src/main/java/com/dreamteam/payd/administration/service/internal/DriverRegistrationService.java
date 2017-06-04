package com.dreamteam.payd.administration.service.internal;

import com.dreamteam.payd.administration.model.Citizen;

import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
public interface DriverRegistrationService {
    List<Citizen> queryCitizensByDetails(String query);

    Citizen findCitizenById(Long citizenId);
}
