package com.dreamteam.payd.administration.service.police;

import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Cartracker;
import com.dreamteam.payd.administration.model.Citizen;
import com.dreamteam.payd.administration.model.Ownership;

import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
public interface CarService {

    /**
     * Retrieve all Car objects from the database.
     *
     * @return A list of all Car objects.
     */
    List<Car> getAllCars();

    /**
     * Retrieve the Car object with the matching Id from the database.
     *
     * @param id The Id to find the Car object by.
     * @return The found Car object.
     */
    Car getCarById(Long id);

    /**
     * Retrieve all Cartracker objects from the database.
     *
     * @return A list of all Cartracker objects.
     */
    List<Cartracker> getAllCartrackers();

    /**
     * Retrieve the Cartracker object with the matching Id from the database.
     *
     * @param id The Id to find the Cartracker object by.
     * @return The found Cartracker object.
     */
    Cartracker getCartrackerById(Long id);

    /**
     * Retrieve all Citizen objects from the database.
     *
     * @return A list of all Citizen objects.
     */
    List<Citizen> getAllCitizens();

    /**
     * Retrieve the Citizen object with the matching Id from the database.
     *
     * @param id The Id to find the Citizen object by.
     * @return The found Citizen object.
     */
    Citizen getCitizenById(Long id);

    /**
     * Retrieve all Ownership objects from the database.
     * @return A list of all Ownership objects.
     */
    List<Ownership> getAllOwnerships();

    /**
     * Retrieve the Ownership object with the matching Id from the database.
     *
     * @param id The Id to find the Ownership object by.
     * @return The found Ownership object.
     */
    Ownership getOwnershipById(Long id);

}
