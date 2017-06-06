package com.dreamteam.payd.administration.bean.settings.region;

import com.dreamteam.payd.administration.dao.RegionDao;
import com.dreamteam.payd.administration.dao.qualifier.CollectionMock;
import com.dreamteam.payd.administration.dao.qualifier.JPA;
import com.dreamteam.payd.administration.model.GeoLocation;
import com.dreamteam.payd.administration.model.Region;
import com.dreamteam.payd.administration.service.internal.RegionService;
import com.dreamteam.payd.administration.util.ContextUtil;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Polygon;

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

    private MapModel polygonModel;

    public void init() {
        if (!ContextUtil.isAjaxRequest(FacesContext.getCurrentInstance())) {
            regions = new ArrayList<>();
            polygonModel = new DefaultMapModel();
            construct();
        }
    }

    private void construct() {
        this.regions = regionService.getAll();
    }

    public List<Region> findMatchingRegions(String query) {
        List<Region> foundRegions = new ArrayList<>();
        for (Region region : this.regions) {
            if (region.getName().contains(query)) {
                foundRegions.add(region);
            }
        }
        return foundRegions;
    }

    public void setMapPolygon(SelectEvent event) {
        polygonModel.getPolygons().clear();
        Polygon polygon = new Polygon();
        for (GeoLocation geo :selectedRegion.getGeoLocations()) {
            polygon.getPaths().add(new LatLng(geo.getLatitude(), geo.getLongitude()));
        }
        polygon.setStrokeColor("#adadad");
        polygon.setFillColor("#c6c6c6");
        polygon.setStrokeOpacity(0.7);
        polygon.setFillOpacity(0.7);
        polygonModel.addOverlay(polygon);
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

    public MapModel getPolygonModel() {
        return polygonModel;
    }

    public void setPolygonModel(MapModel polygonModel) {
        this.polygonModel = polygonModel;
    }

    //</editor-fold>
}
