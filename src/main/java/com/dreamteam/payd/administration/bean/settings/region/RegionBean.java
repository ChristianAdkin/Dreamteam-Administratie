package com.dreamteam.payd.administration.bean.settings.region;

import com.dreamteam.payd.administration.model.Region;
import com.dreamteam.payd.administration.service.internal.RegionService;
import com.dreamteam.payd.administration.util.ContextUtil;
import org.primefaces.event.SelectEvent;

import javax.faces.application.FacesMessage;
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
    private RegionService regionService;

    private List<Region> regions;
    private Region selectedRegion;

    public void init() {
        if (!ContextUtil.isAjaxRequest(FacesContext.getCurrentInstance())) {
            regions = new ArrayList<>();
            construct();
        }
    }

    private void construct() {
        this.regions = regionService.getAll();
    }

    public List<Region> findMatchingRegions(String query) {
        List<Region> allRegions = regionService.getAll();
        List<Region> foundRegions = new ArrayList<>();
        for (int i = 0; i < allRegions.size(); i++) {
            Region region = allRegions.get(i);
            if (region.getName().toLowerCase().contains(query.toLowerCase())) {
                foundRegions.add(region);
            }
        }
        return foundRegions;
    }

    public void onItemSelect(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
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
