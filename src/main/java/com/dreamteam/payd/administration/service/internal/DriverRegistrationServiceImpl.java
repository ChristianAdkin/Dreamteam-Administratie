package com.dreamteam.payd.administration.service.internal;

import com.dreamteam.payd.administration.dao.CitizenDao;
import com.dreamteam.payd.administration.dao.OwnershipDao;
import com.dreamteam.payd.administration.dao.auth.UserDao;
import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Citizen;
import com.dreamteam.payd.administration.model.Ownership;
import com.dreamteam.payd.administration.model.auth.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Adkin on 28/03/2017.
 */
@Stateless
public class DriverRegistrationServiceImpl implements DriverRegistrationService {

    @Inject
    private CitizenDao citizenDao;
    @Inject
    private OwnershipDao ownershipDao;
    @Inject
    private UserDao userDao;

    @Override
    public List<Citizen> queryCitizensByDetails(String query) {
        return citizenDao.queryByDetails(query);
    }

    @Override
    public Citizen findCitizenById(Long citizenId) {
        return citizenDao.findById(citizenId);
    }

    @Override
    public Citizen findCitizenByCSN(String csn) { return citizenDao.findByCSN(csn); }

    @Override
    public Ownership getOwnershipByCar(Car car) {
        return ownershipDao.getCurrentOwnershipByCar(car);
    }

    @Override
    public Citizen getCitizenByCar(Car car) {
        return this.getOwnershipByCar(car).getOwner();
    }

    @Override
    public void createCitizen(Citizen citizen) {
        this.citizenDao.create(citizen);
    }

    @Override
    public Citizen updateCitizen(Citizen citizen) {
        return this.citizenDao.update(citizen);
    }

    @Override
    public List<Ownership> getOwnershipsByCitizen(Citizen citizen) {
        return this.ownershipDao.getCurrentOwnershipsByCitizen(citizen);
    }

    @Override
    public List<Car> getCarsByCitizen(Citizen citizen) {
        List<Car> cars = new ArrayList<>();
        for (Ownership ownership : this.getOwnershipsByCitizen(citizen)) {
            cars.add(ownership.getOwned());
        }
        return cars;
    }

    @Override
    public List<Ownership> getPastOwnershipsByCitizen(Citizen citizen) {
        return this.ownershipDao.getPastOwnershipsByCitizen(citizen);
    }
}
