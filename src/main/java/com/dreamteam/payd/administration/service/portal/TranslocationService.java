package com.dreamteam.payd.administration.service.portal;

import com.dreamteam.payd.administration.api.portal.DTO.CoordinateDTO;
import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Day;

import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
public interface TranslocationService {
    Car getCarById(Long id);
    List<Car> getAllCars();
    List<Car> getCarsByUser(Long userId);

    /**
     * Retrieve all CoordinateDTO's for a given route id
     *
     * @param routeId The Id of the Route.
     * @return A list of all CoordinatesDTO's from a route.
     */
    List<CoordinateDTO> getCoordinateDtosOfRoute(Long routeId);

    /**
     * Get the amount of driven kilometers this day by the given user id
     *
     * @param userId The Id to identify the user.
     * @return Long, the amount of kilometers driven today by the given user
     */
    Double getAmountOfDrivenKmTodayOfUser(Long userId);

    /**
     * Get the amount of driven kilometers this month by the given user id
     *
     * @param userId The Id to identify the user.
     * @return Long, the amount of kilometers driven this month by the given user
     */
    Double getAmountOfDrivenKmMonthOfUser(Long userId);

    /**
     * Retrieve a list of days of the last 5 months by the given user id
     *
     * @param userId The Id to identify the user.
     * @return A list of Day's of the last 5 months by the given user
     */
    List<Day> getRecentDrivenDaysOfUser(Long userId);

    /**
     * Get the amount of vehicles owned by the given user id
     *
     * @param userId The Id to identify the user.
     * @return Long, the amount of vehicles owned by the given user
     */
    Long getAmountOfVehiclesOfUser(Long userId);
}
