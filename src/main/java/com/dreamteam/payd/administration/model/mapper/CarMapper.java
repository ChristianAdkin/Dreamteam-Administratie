package com.dreamteam.payd.administration.model.mapper;

import com.dreamteam.payd.administration.api.shared.CarDTO;
import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.api.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public class CarMapper {

    public static CarDTO toDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(1L);
        carDTO.setLicensePlate(car.getLicenceplate());
        carDTO.setVin(car.getVIN());
        carDTO.setIcan(car.getCartracker().getICAN());
        carDTO.setFuelType(car.getCarType());
        carDTO.setVehicleColor(car.getColour());
        return carDTO;
    }

    public static List<CarDTO> toDTO(List<Car> cars) {
        List<CarDTO> carDTOS = new ArrayList<>();
        for (Car car : cars) {
            carDTOS.add(toDTO(car));
        }
        return carDTOS;
    }
}
