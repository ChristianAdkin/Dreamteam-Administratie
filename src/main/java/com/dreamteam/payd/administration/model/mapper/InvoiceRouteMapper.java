package com.dreamteam.payd.administration.model.mapper;

import com.dreamteam.payd.administration.api.portal.DTO.InvoiceRouteDTO;
import com.dreamteam.payd.administration.model.Route;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by loci on 4-6-17.
 */
public class InvoiceRouteMapper {

    public List<InvoiceRouteDTO> to(List<Route> routes){
        /*
        Order routes by most recent first, then create invoiceDTOs
         */
        List<Route> newRoutes = new ArrayList<>(routes);
        Collections.sort(newRoutes); //implemented comparable so should be fine.

        List<InvoiceRouteDTO> dtos = new ArrayList<>();

        for (Route r : newRoutes) {
            InvoiceRouteDTO dto = new InvoiceRouteDTO(r.getId(), r.getPrice().longValue(), r.getDay().getDayDate(), r.getDay().getDayDate(), Double.doubleToLongBits(r.getDistance()));
            /*
            InvoiceRouteDTO has a start and end date, but a route only has a single Day with a single Date object,
            so currently the start and end time of a DTO will be the same.
             */
            dtos.add(dto);
        }
        return dtos;
    }
}
