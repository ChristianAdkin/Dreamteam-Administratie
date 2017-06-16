package com.dreamteam.payd.administration.model.mapper;

import com.dreamteam.payd.administration.bean.jms.dto.CarDetailsDto;
import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.util.BaseMapperUtil;

/**
 * Created by hein on 6/13/17.
 */
public class CarDetailsMapper extends BaseMapperUtil<Car, CarDetailsDto> {
    @Override
    public CarDetailsDto to(Car car) {
        CarDetailsDto carDetails = new CarDetailsDto();
        carDetails.setICAN(car.getCartracker().getICAN());
        carDetails.setLicenceplate(car.getLicenceplate());
        carDetails.setFuelType(car.getFuelType());
        carDetails.setColour(car.getColour());
        return carDetails;
    }
}
