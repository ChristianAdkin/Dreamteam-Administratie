package com.dreamteam.payd.administration.bean.jms;

import com.dreamteam.payd.administration.bean.jms.dto.CarDetailsDto;
import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.mapper.CarDetailsMapper;
import com.dreamteam.payd.administration.service.internal.VehicleService;
import com.google.gson.Gson;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.*;
import javax.json.JsonObject;
import java.util.List;

/**
 * Created by hein on 6/13/17.
 */
@MessageDriven(name = "cardetailsrequestbean", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/carDetailsRequestQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "carDetailsRequestQueue"),
        @ActivationConfigProperty(propertyName = "resourceAdapter", propertyValue = "activemq-rar")
})
public class CarDetailsRequestBean implements MessageListener {
    // TODO make more robust
    @Inject
    private VehicleService vehicleService;
    @Inject
    private JMSContext context;

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                String carDetailRequestJson = ((TextMessage) message).getText();
                if (!(carDetailRequestJson == null || carDetailRequestJson.isEmpty())) {
                    Car car = retrieveCar(carDetailRequestJson);
                    CarDetailsDto carDetailsDto = new CarDetailsMapper().to(car);
                    String carDetailsResponse = new Gson().toJson(carDetailsDto);
                    reply(message, carDetailsResponse);
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    private Car retrieveCar(String carDetailJson) {
        JsonObject carObject = new Gson().fromJson(carDetailJson, JsonObject.class);
        String ican = carObject.getString("ICAN");
        List<Car> cars = vehicleService.findCarByICAN(ican);
        return cars.get(0);
    }

    private void reply(Message message, String carDetailsResponse) {
        try {
            TextMessage response = context.createTextMessage();
            response.setText(carDetailsResponse);
            response.setJMSDestination(message.getJMSReplyTo());
            response.setJMSCorrelationID(message.getJMSCorrelationID());
            context.createProducer().send(message.getJMSReplyTo(), response);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
