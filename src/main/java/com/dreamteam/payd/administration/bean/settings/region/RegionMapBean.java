package com.dreamteam.payd.administration.bean.settings.region;

import com.dreamteam.payd.administration.model.GeoLocation;
import com.dreamteam.payd.administration.model.Region;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Polygon;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by hein on 6/6/17.
 */
@Named
@RequestScoped
public class RegionMapBean {

    @Inject
    private RegionBean regionBean;

    private MapModel polygonModel;
    private Region selectedRegion;

    @PostConstruct
    public void init() {
        this.selectedRegion = regionBean.getSelectedRegion();
        this.polygonModel = new DefaultMapModel();
    }

    public MapModel getPolygonModel() {
        return polygonModel;
    }

    public void setPolygonModel(MapModel polygonModel) {
        this.polygonModel = polygonModel;
    }

    public void onMapPolygon(SelectEvent event) {
        selectedRegion = regionBean.getSelectedRegion();
        polygonModel.getPolygons().clear();
        Polygon polygon = new Polygon();
        for (GeoLocation geo : selectedRegion.getGeoLocations()) {
            polygon.getPaths().add(new LatLng(geo.getLatitude(), geo.getLongitude()));
        }
        polygon.setStrokeColor("#adadad");
        polygon.setFillColor("#c6c6c6");
        polygon.setStrokeOpacity(0.7);
        polygon.setFillOpacity(0.7);
        polygonModel.addOverlay(polygon);
    }
}
