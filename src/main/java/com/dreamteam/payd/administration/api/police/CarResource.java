package com.dreamteam.payd.administration.api.police;
import com.dreamteam.payd.administration.api.police.DTO.StolenDTO;
import com.dreamteam.payd.administration.api.shared.CarDTO;
import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.mapper.CarMapper;
import com.dreamteam.payd.administration.model.mapper.CitizenMapper;
import com.dreamteam.payd.administration.model.mapper.OwnershipMapper;
import com.dreamteam.payd.administration.service.police.CarService;
import com.dreamteam.payd.administration.util.BaseMapperUtil;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import static com.dreamteam.payd.administration.util.APIUtil.*;

/**
 * Created by Christian Adkin on 04/04/2017.
 */
@Path("police/api/")
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
    @Path("cars/ican/{ican}")
    public Response getCarsByIcan(@PathParam("ican") String ICAN) {
        return buildResponse(new CarMapper().to(this.carService.findByICAN(ICAN)));
    }

    @POST
    @Path("cars/{ican}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response postCarAsStolen(@PathParam("ican") String ICAN, String stolen) {
        try {
            StolenDTO stolenDTO = new Gson().fromJson(stolen, StolenDTO.class);
            Car car = this.carService.findByICAN(ICAN).get(0);

            if (car == null) {
                return Response.serverError().build();
            }
            this.carService.updateCarWithStolenDto(car, stolenDTO);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.serverError().build();
        }
    }
}
