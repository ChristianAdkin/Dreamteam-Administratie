package com.dreamteam.payd.administration.service.police;

import com.dreamteam.payd.administration.api.police.DTO.StolenDTO;
import com.dreamteam.payd.administration.dao.CarDao;
import com.dreamteam.payd.administration.dao.CartrackerDao;
import com.dreamteam.payd.administration.dao.CitizenDao;
import com.dreamteam.payd.administration.dao.OwnershipDao;
import com.dreamteam.payd.administration.model.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Christian Adkin on 04/04/2017.
 */
@Stateless
public class CarServiceImpl implements CarService {

    @Inject
    private CarDao carDao;
    @Inject
    private CartrackerDao cartrackerDao;
    @Inject
    private CitizenDao citizenDao;
    @Inject
    private OwnershipDao ownershipDao;

    @Override
    public List<Car> getAllCars() {
        return carDao.getAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carDao.findById(id);
    }

    @Override
    public List<Cartracker> getAllCartrackers() {
        return cartrackerDao.getAll();
    }

    @Override
    public Cartracker getCartrackerById(Long id) {
        return cartrackerDao.findById(id);
    }

    @Override
    public List<Citizen> getAllCitizens() {
        return citizenDao.getAll();
    }

    @Override
    public Citizen getCitizenById(Long id) {
        return citizenDao.findById(id);
    }

    @Override
    public List<Ownership> getAllOwnerships() {
        return ownershipDao.getAll();
    }

    @Override
    public Ownership getOwnershipById(Long id) {
        return ownershipDao.findById(id);
    }

    @Override
    public void create(Car car) {
        this.carDao.create(car);
    }

    @Override
    public void create(Citizen citizen) {
        this.citizenDao.create(citizen);
    }

    @Override
    public void create(Ownership ownership) {
        this.ownershipDao.create(ownership);
    }

    @Override
    public List<Car> findByICAN(String ICAN) {
        return this.carDao.findByICAN(ICAN);
    }

    @Override
    public void updateCarWithStolenDto(Car car, StolenDTO stolenDTO) {
        switch(stolenDTO.getCarStatus()) {
            case("stolen"):
                car.setCarStatus(CarStatus.STOLEN);
                break;
            case("found"):
                car.setCarStatus(CarStatus.FOUND);
                break;
            default:
                car.setCarStatus(CarStatus.DEFAULT);
                break;
        }

        car.setComments(stolenDTO.getComments());

        this.carDao.update(car);
    }

}
