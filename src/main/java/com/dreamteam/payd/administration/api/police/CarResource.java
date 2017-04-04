package com.dreamteam.payd.administration.api.police;
import com.dreamteam.payd.administration.service.police.CarService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Christian Adkin on 04/04/2017.
 */
@Path("car")
public class CarResource {

    @Inject
    private CarService carService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "test";
    }

}
