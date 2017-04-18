package com.dreamteam.payd.administration.bean.settings.region;

import com.dreamteam.payd.administration.dao.RegionDao;
import com.dreamteam.payd.administration.dao.qualifier.CollectionMock;
import com.dreamteam.payd.administration.dao.qualifier.JPA;
import com.dreamteam.payd.administration.model.Region;
import com.dreamteam.payd.administration.util.ContextUtil;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Adkin on 11/04/2017.
 */
@Named
@ViewScoped
public class RegionBean implements Serializable {

    @Inject
    @JPA
    private RegionDao regionDao;

    private List<Region> regions;
    private Region selectedRegion;

    public void init() {
        if (!ContextUtil.isAjaxRequest(FacesContext.getCurrentInstance())) {
            regions = new ArrayList<>();
            construct();
        }
    }

    private void construct() {
        this.regions = regionDao.getAll();
    }

    public List<Region> completeRegion(String query) {
        List<Region> foundRegions = new ArrayList<>();
        for (Region region : this.regions) {
            if (region.getName().contains(query)) {
                foundRegions.add(region);
            }
        }
        return foundRegions;
    }

    //<editor-fold desc="Getters/setters">
    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public Region getSelectedRegion() {
        return selectedRegion;
    }

    public void setSelectedRegion(Region selectedRegion) {
        this.selectedRegion = selectedRegion;
    }

    //</editor-fold>
}
