package com.dreamteam.payd.administration.converter;

import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.service.police.CarService;
import com.dreamteam.payd.administration.util.GeneralUtil;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Christian Adkin on 09/05/2017.
 */
@Named
public class CarConverter implements Converter, Serializable {

    @Inject
    private CarService carService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (GeneralUtil.nullOrEmpty(s)) {
            return null;
        }
        Car car = carService.getCarById(Long.parseLong(s));
        return car;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return o.toString();
    }
}
