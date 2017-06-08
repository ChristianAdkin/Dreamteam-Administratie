package com.dreamteam.payd.administration.converter;

import com.dreamteam.payd.administration.bean.settings.region.RegionBean;
import com.dreamteam.payd.administration.dao.RegionDao;
import com.dreamteam.payd.administration.dao.qualifier.CollectionMock;
import com.dreamteam.payd.administration.dao.qualifier.JPA;
import com.dreamteam.payd.administration.model.Region;
import com.dreamteam.payd.administration.util.GeneralUtil;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Christian Adkin on 11/04/2017.
 */
@FacesConverter("regionConverter")
public class RegionConverter implements Converter, Serializable {

    @Inject
    private RegionBean regionBean;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return regionBean.getRegions().get(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Region!"));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object region) {
        if (region != null) {
            return String.valueOf(((Region) region).getId());
        } else {
            return null;
        }
    }
}
