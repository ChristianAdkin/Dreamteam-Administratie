package com.dreamteam.payd.administration.model;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String areaCode;
    private String name;

    @OneToMany
    private List<RegionPrice> regionPrices;

    @OneToMany
    private List<GeoLocation> geoLocations;

    private Double distance;

    public Region() {
        regionPrices = new ArrayList<>();
        geoLocations = new ArrayList<>();
    }

    public Region(String areaCode, String name) {
        this();
        this.areaCode = areaCode;
        this.name = name;
        regionPrices = new ArrayList<>();
        geoLocations = new ArrayList<>();
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RegionPrice> getRegionPrices() {
        return regionPrices;
    }

    public void setRegionPrices(List<RegionPrice> regionPrices) {
        this.regionPrices = regionPrices;
    }

    public List<GeoLocation> getGeoLocations() {
        return geoLocations;
    }

    public void setGeoLocations(List<GeoLocation> geoLocations) {
        this.geoLocations = geoLocations;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String number) {
        this.areaCode = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Region region = (Region) o;

        if (areaCode != region.areaCode) return false;
        if (id != null ? !id.equals(region.id) : region.id != null) return false;
        return name != null ? name.equals(region.name) : region.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
