package com.dreamteam.payd.administration.converter;

import com.dreamteam.payd.administration.bean.settings.region.RegionBean;
import com.dreamteam.payd.administration.dao.RegionDao;
import com.dreamteam.payd.administration.dao.qualifier.CollectionMock;
import com.dreamteam.payd.administration.dao.qualifier.JPA;
import com.dreamteam.payd.administration.model.Region;
import com.dreamteam.payd.administration.util.GeneralUtil;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Christian Adkin on 11/04/2017.
 */
@Named
public class RegionConverter implements Converter, Serializable {

    @Inject
    private RegionBean regionBean;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (GeneralUtil.nullOrEmpty(s)) {
            return null;
        }

        Long id = Long.parseLong(s);
        for (Region region : regionBean.getRegions()) {
            if (region.getId().equals(id)) {
                return region;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return o.toString();
    }
}
