package com.dreamteam.payd.administration.api.authentication;

import com.dreamteam.payd.administration.service.portal.UserService;

import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


/**
 * Created by Christian Adkin on 19/05/2017.
 */
@Path("api/authentication")
public class AuthenticationResource {

    @Inject
    private UserService userService;

    @POST
    public Response authenticate(@FormParam("username") String username, @FormParam("password") String password) {
        try {
            //Authenticate the user.
            userService.authenticate(username, password);
        } catch (AuthenticationException authEx) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        return Response.status(404).build();
    }
}
