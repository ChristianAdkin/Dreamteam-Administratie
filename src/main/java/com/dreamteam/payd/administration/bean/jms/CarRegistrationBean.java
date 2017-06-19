package com.dreamteam.payd.administration.bean.jms;

import com.dreamteam.payd.administration.bean.jms.dto.CarRegistrationDto;
import com.dreamteam.payd.administration.dao.OwnershipDao;
import com.dreamteam.payd.administration.dao.auth.RoleDao;
import com.dreamteam.payd.administration.dao.auth.UserDao;
import com.dreamteam.payd.administration.model.*;
import com.dreamteam.payd.administration.model.auth.Role;
import com.dreamteam.payd.administration.model.auth.User;
import com.dreamteam.payd.administration.service.internal.DriverRegistrationService;
import com.dreamteam.payd.administration.service.internal.VehicleService;
import com.google.gson.Gson;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.Date;

/**
 * Created by hein on 6/13/17.
 */
@MessageDriven(name = "carreceivebean", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/carReceiveQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/carReceiveQueue"),
        @ActivationConfigProperty(propertyName = "resourceAdapter", propertyValue = "activemq-rar")
})
public class CarRegistrationBean implements MessageListener {

    @Inject
    private VehicleService vehicleService;
    @Inject
    private DriverRegistrationService driverRegistrationService;
    @Inject
    private OwnershipDao ownershipDao;
    @Inject
    private UserDao userDao;
    @Inject
    private RoleDao roleDao;

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                String carRegistrationDetailsJson = ((TextMessage) message).getText();
                if (!(carRegistrationDetailsJson == null || carRegistrationDetailsJson.isEmpty())) {
                    processCar(carRegistrationDetailsJson);
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    private void processCar(String carRegistrationDetailsJson) {
        CarRegistrationDto carRegistrationDetails = new Gson().fromJson(carRegistrationDetailsJson, CarRegistrationDto.class);
        Citizen citizen = driverRegistrationService.findCitizenByCSN(carRegistrationDetails.getCSN());
        if (citizen == null) {
            citizen = new Citizen(carRegistrationDetails.getCSN(),
                    carRegistrationDetails.getFirstName(),
                    carRegistrationDetails.getLastName());
        }
        Car car = new Car(carRegistrationDetails.getVIN(),
                carRegistrationDetails.getLicenceplate(),
                FuelType.valueOf(carRegistrationDetails.getFuelType()),
                carRegistrationDetails.getColour());
        Cartracker carTracker = new Cartracker(carRegistrationDetails.getICAN());
        carTracker.setCar(car);
        Ownership ownership = new Ownership(citizen, car, new Date());
        User user = new User(carRegistrationDetails.getEmailAddress(), "test");
        Role role = roleDao.findByString("citizen");
        user.addRole(role);
        citizen.setUser(user);
        persistCar(car, carTracker, citizen, ownership, user);
    }

    private void persistCar(Car car, Cartracker cartracker, Citizen citizen, Ownership ownership, User user) {
        vehicleService.createCar(car);
        vehicleService.createCartracker(cartracker);
        driverRegistrationService.createCitizen(citizen);
        ownershipDao.create(ownership);
        userDao.create(user);
    }
}
