package com.dreamteam.payd.administration.model.mapper;

import com.dreamteam.payd.administration.api.shared.CarDTO;
import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.util.BaseMapperUtil;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public class CarMapper extends BaseMapperUtil<Car, CarDTO> {

    @Override
    public CarDTO to(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setLicensePlate(car.getLicenceplate());
        carDTO.setVin(car.getVIN());
        carDTO.setIcan(car.getCartracker().getICAN());
        carDTO.setFuelType(car.getFuelType());
        carDTO.setVehicleColor(car.getColour());
        return carDTO;
    }
}
