package com.dreamteam.payd.administration.bean;

import com.dreamteam.payd.administration.dao.*;
import com.dreamteam.payd.administration.dao.qualifier.JPA;
import com.dreamteam.payd.administration.model.*;
import com.dreamteam.payd.administration.util.GeneralUtil;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.Serializable;
import java.math.BigDecimal;
import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Christian Adkin on 18/04/2017.
 */
@Singleton
@Startup
public class Initializer implements Serializable {

    @Inject
    @JPA
    private RegionDao regionDao;
    @Inject
    private RegionPriceDao regionPriceDao;

    @Inject
    private CarDao carDao;
    @Inject
    private CartrackerDao cartrackerDao;

    @Inject
    private CitizenDao citizenDao;
    @Inject
    private OwnershipDao ownershipDao;

    @PostConstruct
    public void init() {
        //Create some default Regions
        this.createRegions();

        //Create some cars
        List<Car> cars = this.createCars();

        //For each car create a Cartracker
        cars.forEach(this::createCartracker);

        //Create some citizens and link them to random cars
        this.createCitizens().forEach(e -> createOwnership(e, GeneralUtil.getRandomElement(cars), new Date(), new Date()));
    }

    private void createRegions() {
        Region region = new Region(1, "Venray");
        RegionPrice regionPrice = new RegionPrice(new BigDecimal(200L), new Date());
        regionPrice.setEndDate(new Date());
        regionPriceDao.create(regionPrice);
        region.addRegionPrice(regionPrice);

        regionPrice = new RegionPrice(new BigDecimal(100L), new Date());
        regionPriceDao.create(regionPrice);
        region.addRegionPrice(regionPrice);
        regionDao.create(region);
        regionDao.create(new Region(2, "Eindhoven"));
        regionDao.create(new Region(3, "Amsterdam"));
        regionDao.create(new Region(4, "Elst"));
        regionDao.create(new Region(5, "Arnhem"));
    }

    private List<Car> createCars() {
        List<Car> createdCars = new ArrayList<>();

        createdCars.add(createCar("ICAN1", "VIN1", "LicencePlate1"));
        createdCars.add(createCar("ICAN2", "VIN2", "LicencePlate2"));
        createdCars.add(createCar("ICAN3", "VIN3", "LicencePlate3"));
        createdCars.add(createCar("ICAN4", "VIN4", "LicencePlate4"));

        return createdCars;
    }

    private Car createCar(String ICAN, String VIN, String licencePlate) {
        Car car = new Car(ICAN, VIN, licencePlate);
        carDao.create(car);
        return car;
    }

    private Cartracker createCartracker(Car car) {
        Cartracker cartracker = new Cartracker(car);
        cartrackerDao.create(cartracker);
        return cartracker;
    }

    private List<Citizen> createCitizens() {
        List<Citizen> createdCitizens = new ArrayList<>();

        createdCitizens.add(createCitizen("Christian", "Adkin"));
        createdCitizens.add(createCitizen("R", "Rick", "van", "Duijnhoven"));
        createdCitizens.add(createCitizen("Hein", "Dauven"));
        createdCitizens.add(createCitizen("Stef", "Philipsen"));
        createdCitizens.add(createCitizen("Jasper", "Rouwhorst"));
        createdCitizens.add(createCitizen("Mick", "Wonnink"));

        return createdCitizens;
    }

    private Citizen createCitizen(String firstName, String lastName) {
        return createCitizen(null, firstName, null, lastName);
    }

    private Citizen createCitizen(String initials, String firstName, String preposition, String lastName) {
        Citizen citizen = new Citizen(firstName, lastName);
        citizen.setInitials(initials);
        citizen.setPreposition(preposition);
        citizenDao.create(citizen);
        return citizen;
    }

    private Ownership createOwnership(Citizen citizen, Car car, Date startDate, Date endDate) {
        Ownership ownership = new Ownership(citizen, car, startDate, endDate);
        ownershipDao.create(ownership);
        return ownership;
    }

    @PreDestroy
    public void destroy() {

    }

}
