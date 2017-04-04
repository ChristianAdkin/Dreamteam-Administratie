package com.dreamteam.payd.administration.api.internal;

import com.dreamteam.payd.administration.service.internal.DriverRegistrationService;
import com.dreamteam.payd.administration.service.internal.DriverRegistrationServiceImpl;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by Christian Adkin on 04/04/2017.
 */
@Stateless
public class DriverRegistrationResource {

    @Inject
    private DriverRegistrationService driverRegistrationService;
}
