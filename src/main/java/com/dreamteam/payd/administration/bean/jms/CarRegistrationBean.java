package com.dreamteam.payd.administration.bean.jms;

import com.dreamteam.payd.administration.bean.jms.dto.CarRegistrationDto;
import com.dreamteam.payd.administration.dao.OwnershipDao;
import com.dreamteam.payd.administration.model.*;
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
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "carReceiveQueue"),
        @ActivationConfigProperty(propertyName = "resourceAdapter", propertyValue = "activemq-rar")
})
public class CarRegistrationBean implements MessageListener {

    @Inject
    private VehicleService vehicleService;
    @Inject
    private DriverRegistrationService driverRegistrationService;
    @Inject
    private OwnershipDao ownershipDao;

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

        persistCar(car, carTracker, citizen, ownership);
    }

    private void persistCar(Car car, Cartracker cartracker, Citizen citizen, Ownership ownership) {
        vehicleService.createCar(car);
        vehicleService.createCartracker(cartracker);
        driverRegistrationService.createCitizen(citizen);
        ownershipDao.create(ownership);
    }
}
