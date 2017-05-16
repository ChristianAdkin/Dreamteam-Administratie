package com.dreamteam.payd.administration.api.police;
import com.dreamteam.payd.administration.api.shared.CarDTO;
import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.mapper.CarMapper;
import com.dreamteam.payd.administration.model.mapper.CitizenMapper;
import com.dreamteam.payd.administration.model.mapper.OwnershipMapper;
import com.dreamteam.payd.administration.service.police.CarService;
import com.dreamteam.payd.administration.util.BaseMapperUtil;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import static com.dreamteam.payd.administration.util.APIUtil.*;

/**
 * Created by Christian Adkin on 04/04/2017.
 */
@Path("police")
public class CarResource {

    @Inject
    private CarService carService;

    @GET
    @Path("cars/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    public Response getCar(@PathParam("id") Long id) {
        Car car = carService.getCarById(id);
        CarDTO carDTO = new CarMapper().to(car);
        return buildResponse(carDTO);
    }

    @GET
    @Path("cars")
    public Response getAllCars() {
        return buildResponse(new CarMapper().to(carService.getAllCars()));
    }

    @GET
    @Path("citizens/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCitizen(@PathParam("id") Long id) {
        return buildResponse(new CitizenMapper().to(carService.getCitizenById(id)));
    }

    @GET
    @Path("citizens")
    public Response getAllCitizens() {
        return buildResponse(new CitizenMapper().to(carService.getAllCitizens()));
    }

    @GET
    @Path("ownerships")
    public Response getAllOwnerships() {
        return buildResponse(new OwnershipMapper().to(carService.getAllOwnerships()));
    }

    @GET
    @Path("ownerships/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    public Response getOwnership(@PathParam("id") Long id) {
        return buildResponse(new OwnershipMapper().to(carService.getOwnershipById(id)));
    }

    @GET
    @Path("test")
    public String test() {
       return "test";
    }

}
