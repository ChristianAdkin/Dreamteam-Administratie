package com.dreamteam.payd.administration.service.internal;

import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Citizen;
import com.dreamteam.payd.administration.model.Ownership;

import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
public interface DriverRegistrationService {
    List<Citizen> queryCitizensByDetails(String query);

    Citizen findCitizenById(Long citizenId);

    Citizen findCitizenByCSN(String csn);

    Ownership getOwnershipByCar(Car car);

    Citizen getCitizenByCar(Car car);

    void createCitizen(Citizen citizen);

    Citizen updateCitizen(Citizen citizen);

    List<Ownership> getOwnershipsByCitizen(Citizen citizen);

    List<Car> getCarsByCitizen(Citizen citizen);

    List<Ownership> getPastOwnershipsByCitizen(Citizen citizen);
}
