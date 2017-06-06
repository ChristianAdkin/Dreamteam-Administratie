package com.dreamteam.payd.administration.bean;

import com.dreamteam.payd.administration.dao.*;
import com.dreamteam.payd.administration.dao.auth.RoleDao;
import com.dreamteam.payd.administration.dao.auth.UserDao;
import com.dreamteam.payd.administration.dao.qualifier.JPA;
import com.dreamteam.payd.administration.model.*;
import com.dreamteam.payd.administration.model.auth.Role;
import com.dreamteam.payd.administration.model.auth.User;
import com.dreamteam.payd.administration.util.DateUtil;
import com.dreamteam.payd.administration.util.GeneralUtil;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.security.acl.Owner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
    private DayDao dayDao;

    @Inject
    private InvoiceDao invoiceDao;

    @Inject
    private OwnershipDao ownershipDao;

    @Inject
    private RoleDao roleDao;

    @Inject
    private RouteDao routeDao;

    @Inject
    private UserDao userDao;

    @PostConstruct
    public void init() {
        User adminUser = new User("administrator", "8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918");
        userDao.create(adminUser);
//        userDao.flush();

        Role adminRole = new Role("admins");
        roleDao.create(adminRole);
        roleDao.flush();

        adminUser.addRole(adminRole);
        adminRole.addUser(adminUser);

        roleDao.update(adminRole);

        User demoUser = new User("angela.merkel@mail.de", "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918");
        userDao.create(demoUser);
        userDao.flush();

        Role role = new Role("citizens");
        roleDao.create(role);
        roleDao.flush();

        role.addUser(demoUser);
        demoUser.addRole(role);

        role = roleDao.update(role);

        Citizen citizen = new Citizen("1337", "Angela", "Merkel");
        citizen.setInitials("MD");
        citizen.setPreposition("Dorothea");
        citizen.setCity("Berlin");
        citizen.setCountry("Germany");
        LocalDateTime localDateTime = LocalDateTime.of(1954, Month.JULY, 17, 0, 0);
        citizen.setDateOfBirth(DateUtil.from(localDateTime));
        citizen.setUser(demoUser);
        citizenDao.create(citizen);
        citizenDao.flush();

        Car car1 = new Car("1J4FJ27P1TL156003", "WOP-ZK-295");
        car1.setColour("Black");
        car1.setFuelType(FuelType.LPG);
        carDao.create(car1);

        Day day = new Day();
        List<Route> routes = new ArrayList<>();
        Route route = new Route(day);
        route.setId(1L);
        routeDao.create(route);
        routes.add(route);
        day.setRoutes(routes);
        day.setDistance(5000L);
        dayDao.create(day);

        for (int i=0; i < 10; i++){
            Invoice invoice = new Invoice(citizen, car1);
            InvoiceLine invoiceLine = new InvoiceLine(new BigDecimal(new Random().nextDouble() * 1200, MathContext.DECIMAL64), invoice);
            invoiceLine.setDay(day);
            invoiceLine.setDistance(new Random().nextDouble()* 400);
            invoice.addInvoiceLine(invoiceLine);

            InvoiceLine invoiceLine2 = new InvoiceLine(new BigDecimal(new Random().nextDouble() * 800, MathContext.DECIMAL64), invoice);
            invoiceLine2.setDay(day);
            invoiceLine2.setDistance(new Random().nextDouble()* 400);
            invoice.addInvoiceLine(invoiceLine2);

            int rndLine = new Random().nextInt(3);
            for (int j=0; j < rndLine; j++){
                InvoiceLine invoiceLine3 = new InvoiceLine(new BigDecimal(new Random().nextDouble() * 800, MathContext.DECIMAL64), invoice);
                invoiceLine3.setDay(day);
                invoiceLine3.setDistance(new Random().nextDouble()* 400);
                invoice.addInvoiceLine(invoiceLine3);
            }

            LocalDateTime localDateTimeInvoice = LocalDateTime.now();
            localDateTimeInvoice = localDateTimeInvoice.withYear(2017);
            localDateTimeInvoice = localDateTimeInvoice.withMonth(i+1);
            localDateTimeInvoice = localDateTimeInvoice.withDayOfMonth(1);
            invoice.setDateOfInvoice(DateUtil.from(localDateTimeInvoice));
            this.invoiceDao.create(invoice);
        }

        Cartracker cartracker = new Cartracker(car1, "DE200000000000001");
        cartrackerDao.create(cartracker);

        Ownership ownership = new Ownership(citizen, car1, DateUtil.from(LocalDateTime.of(2015, Month.NOVEMBER, 12, 0, 0)));
        ownershipDao.create(ownership);

        Car car2 = new Car("3VWPL7AJ8CM316881", "ZIK-AQ-123");
        car2.setColour("Gray");
        car2.setFuelType(FuelType.DIESEL);
        carDao.create(car2);

        Cartracker cartracker2 = new Cartracker(car2, "DE200000000000002");
        cartrackerDao.create(cartracker2);

        Ownership ownership2 = new Ownership(citizen, car2, DateUtil.from(LocalDateTime.of(2015, Month.NOVEMBER, 12, 0, 0)));
        ownershipDao.create(ownership2);

        carDao.flush();
        cartrackerDao.flush();
        ownershipDao.flush();

        User policeUser = new User("police@police.police", "1366FAC71146793A85E98A88AD9BB15ADB9AAC31DA8AC6D73E67059BD5A467A9");
        userDao.create(policeUser);
        userDao.flush();

        Role policeRole = new Role("police");
        roleDao.create(policeRole);
        roleDao.flush();

        policeRole.addUser(policeUser);
        policeUser.addRole(policeRole);

        policeRole = roleDao.update(policeRole);

        construct();
    }

    public void construct() {
        //Create some default Regions
        this.createRegions();

        //Create some cars
        List<Car> cars = this.createCars();

        //For each car create a Cartracker
        int i = 0;
        for (Car e : cars) {
            this.createCartracker(e, "DE20000000000000" + Integer.toString(i));
            i++;
        }

        List<Citizen> citizens =  this.createCitizens();
        cars.forEach(e -> this.createOwnership(GeneralUtil.getRandomElement(citizens), e, new Date(), null));

        //Create some citizens and link them to random cars
        //.forEach(e -> createOwnership(e, GeneralUtil.removeRandomElement(cars), new Date(), null));
    }

    private void createRegions() {
//        Region region = new Region("1", "Venray");
//        RegionPrice regionPrice = new RegionPrice(new BigDecimal(200L), new Date());
//        regionPrice.setEndDate(new Date());
//        regionPriceDao.create(regionPrice);
//        region.setRegionPrice(new BigDecimal(200L));

//        regionPrice = new RegionPrice(new BigDecimal(100L), new Date());
//        regionPriceDao.create(regionPrice);
//        region.addRegionPrice(regionPrice);
//        regionDao.create(region);
//        regionDao.create(new Region("2", "Eindhoven"));
//        regionDao.create(new Region("3", "Amsterdam"));
//        regionDao.create(new Region("4", "Elst"));
//        regionDao.create(new Region("5", "Arnhem"));
    }

    private List<Car> createCars() {
        List<Car> createdCars = new ArrayList<>();

        createdCars.add(createCar("VIN1", "LicencePlate1", FuelType.BIOFUEL, "Red"));
        createdCars.add(createCar("VIN2", "LicencePlate2", FuelType.DIESEL, "Blue"));
        createdCars.add(createCar("VIN3", "LicencePlate3", FuelType.ELECTRIC, "Green"));
        createdCars.add(createCar("VIN4", "LicencePlate4", FuelType.HYBRID,"Gold"));
        createdCars.add(createCar("VIN5", "LicencePlate5", FuelType.BIOFUEL,"Silver"));
        createdCars.add(createCar("VIN6", "LicencePlate6", FuelType.GASOLINE, "Black"));
        createdCars.add(createCar("VIN7", "LicencePlate7", FuelType.BIOFUEL, "Yellow"));
        createdCars.add(createCar("VIN8", "LicencePlate8", FuelType.ELECTRIC, "Cyan"));

        return createdCars;
    }

    private Car createCar(String VIN, String licencePlate, FuelType fuelType, String colour) {
        Car car = new Car(VIN, licencePlate, fuelType, colour);
        carDao.create(car);
        return car;
    }

    private Cartracker createCartracker(Car car, String ICAN) {
        Cartracker cartracker = new Cartracker(car, ICAN);
        cartrackerDao.create(cartracker);
        return cartracker;
    }

    private List<Citizen> createCitizens() {
        List<Citizen> createdCitizens = new ArrayList<>();

        createdCitizens.add(createCitizen("Christian", "Adkin", "christianadkin@hotmail.com", "dreamteam"));
        createdCitizens.add(createCitizen("1234", "R", "Rick", "van", "Duijnhoven", "RickvanDuijnhoven@hotmail.com", "dreamteam"));
        createdCitizens.add(createCitizen("Hein", "Dauven", "HeinDauven@hotmail.com", "dreamteam"));
        createdCitizens.add(createCitizen("Stef", "Philipsen", "StefSven@hotmail.com", "dreamteam"));
        createdCitizens.add(createCitizen("Jasper", "Rouwhorst", "JasperRouwhorst@hotmail.com", "dreamteam"));
        createdCitizens.add(createCitizen("Mick", "Wonnink", "MickWonnink@hotmail.com", "dreamteam"));

        return createdCitizens;
    }

    private Citizen createCitizen(String firstName, String lastName, String email, String password) {
        return createCitizen(null, null, firstName, null, lastName, email, password);
    }

    private Citizen createCitizen(String idNumber, String initials, String firstName, String preposition, String lastName, String email, String password) {
        Citizen citizen = new Citizen(idNumber, firstName, lastName);
        citizen.setInitials(initials);
        citizen.setPreposition(preposition);

        citizen.setUser(createUser(email, password));

        citizenDao.create(citizen);
        return citizen;
    }

    private User createUser(String email, String password) {
        User user = new User(email, password);
        userDao.create(user);
        return user;
    }

    private Ownership createOwnership(Citizen citizen, Car car, Date startDate, Date endDate) {
        if (citizen == null || car == null) {

        }
        Ownership ownership = new Ownership(citizen, car, startDate, endDate);
        ownershipDao.create(ownership);
        return ownership;
    }

    @PreDestroy
    public void destroy() {

    }

}
