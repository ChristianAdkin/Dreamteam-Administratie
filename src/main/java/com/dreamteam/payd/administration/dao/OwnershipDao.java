package com.dreamteam.payd.administration.dao;

import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Citizen;
import com.dreamteam.payd.administration.model.Ownership;

import java.util.List;

/**
 * Created by Christian Adkin on 05/05/2017.
 */
public interface OwnershipDao extends BaseDao<Ownership> {
    Ownership getCurrentOwnershipByCar(Car car);

    List<Ownership> getCurrentOwnershipsByCitizen(Citizen citizen);

    List<Ownership> getPastOwnershipsByCitizen(Citizen citizen);

    Ownership findCurrentCarAndCitizenByIcan(String ICAN);
}
