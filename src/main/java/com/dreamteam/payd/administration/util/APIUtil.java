package com.dreamteam.payd.administration.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Adkin on 07/05/2017.
 */
public class APIUtil {

    private static int SUCCES_CODE = 200;
    private static int NO_ENTITY_FOUND = 404;

    public static Response buildResponse(Object o) {
        if (o !=  null) {
            return Response.ok().entity(o).build();
        }
        return Response.status(NO_ENTITY_FOUND).build();
    }

    public static <T> Response buildResponse(List<T> objects) {
        if (objects != null) {
            if (!objects.isEmpty()) {
                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
                JsonArray objectArray = gson.toJsonTree(objects).getAsJsonArray();
                return Response.ok().entity(objectArray.toString()).build();
            }
        }
        return Response.status(NO_ENTITY_FOUND).build();
    }
}
