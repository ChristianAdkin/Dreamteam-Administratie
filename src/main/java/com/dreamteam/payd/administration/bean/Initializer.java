package com.dreamteam.payd.administration.bean;

import com.dreamteam.payd.administration.dao.CarDao;
import com.dreamteam.payd.administration.dao.CartrackerDao;
import com.dreamteam.payd.administration.dao.RegionDao;
import com.dreamteam.payd.administration.dao.RegionPriceDao;
import com.dreamteam.payd.administration.dao.qualifier.JPA;
import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Cartracker;
import com.dreamteam.payd.administration.model.Region;
import com.dreamteam.payd.administration.model.RegionPrice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.Serializable;
import java.math.BigDecimal;
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

    @PostConstruct
    public void init() {
        this.createRegions();
        this.createCars().forEach(this::createCartracker);
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



    @PreDestroy
    public void destroy() {

    }

}
