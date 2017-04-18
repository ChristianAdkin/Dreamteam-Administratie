package com.dreamteam.payd.administration.model;

import javax.persistence.*;
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

    private int number;
    private String name;

    @OneToMany
    private List<RegionPrice> regionPrices;

    protected Region() {
        regionPrices = new ArrayList<>();
    }

    public Region(int number, String name) {
        this.number = number;
        this.name = name;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RegionPrice> getRegionPrices() {
        return Collections.unmodifiableList(this.regionPrices);
    }

    public boolean addRegionPrice(RegionPrice regionPrice) {
        if (this.regionPrices.contains(regionPrice)) {
            return false;
        }
        return this.regionPrices.add(regionPrice);
    }

    public boolean removeRegionPrice(RegionPrice regionPrice) {
        return this.regionPrices.remove(regionPrice);
    }
}
