package com.dreamteam.payd.administration.dao;

import com.dreamteam.payd.administration.api.portal.DTO.CoordinateDTO;
import com.dreamteam.payd.administration.model.Car;

import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
public interface CarDao extends BaseDao<Car> {
    List<Car> findByICAN(String ICAN);

    List<Car> getCarsByUser(Long userId);

    List<CoordinateDTO> getCoordinatesOfRoute(Long routeId);

    Long getAmountOfDrivenKmTodayOfUser(Long userId);
}
