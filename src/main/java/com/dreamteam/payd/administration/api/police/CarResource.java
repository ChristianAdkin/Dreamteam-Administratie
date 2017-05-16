package com.dreamteam.payd.administration.api.police;
import com.dreamteam.payd.administration.model.mapper.CarMapper;
import com.dreamteam.payd.administration.model.mapper.CitizenMapper;
import com.dreamteam.payd.administration.model.mapper.OwnershipMapper;
import com.dreamteam.payd.administration.service.police.CarService;

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
        return buildResponse(CarMapper.toDTO(carService.getCarById(id)));
    }

    @GET
    @Path("cars")
    public Response getAllCars() {
//        return carService.getAllCars();
//        return Response.ok(carService.getAllCars(), MediaType.APPLICATION_JSON).build();
        return buildResponse(CarMapper.toDTO(carService.getAllCars()));
    }

    @GET
    @Path("citizens/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCitizen(@PathParam("id") Long id) {
        return buildResponse(CitizenMapper.toDTO(carService.getCitizenById(id)));
    }

    @GET
    @Path("citizens")
    public Response getAllCitizens() {
        return buildResponse(CitizenMapper.toDTO(carService.getAllCitizens()));
    }

    @GET
    @Path("ownerships")
    public Response getAllOwnerships() {
        return buildResponse(OwnershipMapper.toDTO(carService.getAllOwnerships()));
    }

    @GET
    @Path("ownerships/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    public Response getOwnership(@PathParam("id") Long id) {
        return buildResponse(OwnershipMapper.toDTO(carService.getOwnershipById(id)));
    }

    @GET
    @Path("test")
    public String test() {
        return "test";
    }

}
