package com.dreamteam.payd.administration.api.police;

import com.dreamteam.payd.administration.service.police.CarService;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by Christian Adkin on 04/04/2017.
 */
@Stateless
public class CarResource {

    @Inject
    private CarService carService;
}
