package com.dreamteam.payd.administration.model.mapper;

import com.dreamteam.payd.administration.api.portal.DTO.InvoiceRouteDTO;
import com.dreamteam.payd.administration.model.Route;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Christian Adkin on 13/06/2017.
 */
public class InvoiceRouteDtoMapper {

    public List<InvoiceRouteDTO> to(List<Route> routes){

        List<Route> newRoutes = new ArrayList<>(routes);
        Collections.sort(newRoutes); //implemented comparable so should be fine.

        List<InvoiceRouteDTO> dtos = new ArrayList<>();

        for (Route r : newRoutes) {
            InvoiceRouteDTO dto = new InvoiceRouteDTO(r.getId(), r.getPrice().doubleValue(),new Date(), new Date(), Double.doubleToLongBits(r.getDistance()));
            /*
            InvoiceRouteDTO has a start and end date, but a route only has a single Day with a single Date object,
            so currently the start and end time of a DTO will be the same.
             */
            dtos.add(dto);
        }
        return dtos;
    }
}
