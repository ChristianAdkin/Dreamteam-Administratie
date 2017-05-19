package com.dreamteam.payd.administration.api.portal;

import com.dreamteam.payd.administration.api.shared.CarDTO;
import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.mapper.CarMapper;
import com.dreamteam.payd.administration.model.mapper.CitizenMapper;
import com.dreamteam.payd.administration.model.mapper.InvoiceMapper;
import com.dreamteam.payd.administration.service.portal.PaymentService;
import com.dreamteam.payd.administration.service.portal.TranslocationService;
import com.dreamteam.payd.administration.service.portal.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.dreamteam.payd.administration.util.APIUtil.*;

/**
 * Created by Christian Adkin on 04/04/2017.
 */
@Path("userportal/api/")
public class UserPortalResource {

    @Inject
    private PaymentService paymentService;
    @Inject
    private TranslocationService translocationService;
    @Inject
    private UserService userService;

    //Gebruiker
    @GET
    @Path("/users/{userId}/cars")
    public Response getAllCarsByUser(@PathParam("userId") Long userId) {
        return buildResponse(
                new CarMapper().to(
                        translocationService.getCarsByUser(userId)
                )
        );
    }

    @GET
    @Path("/users/email/{email}")
    public Response getUserByEmail(@PathParam("email") String email) {
        return buildResponse(
                new CitizenMapper().to(
                        this.userService.getByEmail(email)
                )
        );
    }

    @GET
    @Path("/users/{userId}/dailystats")
    public Response getDailyStatsByUser(@PathParam("userId") Long userId) {
        return buildResponse("test");
    }

    @GET
    @Path("/users/{userId}/drivenkm")
    public Response getDrivenKMByUser(@PathParam("userId") Long userId) {
        return buildResponse("test");
    }
    //End of gebruiker

    //Rekeningen
    @GET
    @Path("/users/{userId}/invoices")
    public Response getInvoicesByUser(@PathParam("userId") Long userId) {
        return buildResponse(
                new InvoiceMapper().to(
                        this.paymentService.getInvoicesByUser(userId)
                )
        );
    }

    @GET
    @Path("invoices/{invoiceId}/days")
    public Response getDaysByInvoice(@PathParam("invoiceId") Long invoiceId) {
        return buildResponse("test");
    }

    @PUT
    @Path("/invoices/{invoiceId}")
    public Response updateInvoice(@PathParam("invoiceId") Long invoiceId) {
        return buildResponse("test");
    }

    @GET
    @Path("days/{dayId}/routes")
    public Response getRoutesByDay(@PathParam("dayId") Long dayId) {
        return buildResponse("test");
    }

    @GET
    @Path("routes/{routeId}/coords")
    public Response getCoordsByRoute(@PathParam("routeId") Long id) {
        return buildResponse("test");
    }
    //End of rekeningen
}
