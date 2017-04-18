package com.dreamteam.payd.administration.bean;

import com.dreamteam.payd.administration.dao.RegionDao;
import com.dreamteam.payd.administration.dao.RegionPriceDao;
import com.dreamteam.payd.administration.dao.qualifier.JPA;
import com.dreamteam.payd.administration.model.Region;
import com.dreamteam.payd.administration.model.RegionPrice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Christian Adkin on 18/04/2017.
 */
@Singleton
@Startup
public class Initializer implements Serializable {

    @Inject
    @JPA
    private RegionDao regionDao;
    @Inject
    private RegionPriceDao regionPriceDao;

    @PostConstruct
    public void init() {
        Region region = new Region(1, "Venray");
        RegionPrice regionPrice = new RegionPrice(new BigDecimal(200L), new Date());
        regionPrice.setEndDate(new Date());
        regionPriceDao.create(regionPrice);
        region.addRegionPrice(regionPriceDao.create(new RegionPrice(new BigDecimal(100L), new Date())));
        region.addRegionPrice(regionPrice);
        regionDao.create(region);
        regionDao.create(new Region(2, "Eindhoven"));
        regionDao.create(new Region(3, "Amsterdam"));
        regionDao.create(new Region(4, "Elst"));
        regionDao.create(new Region(5, "Arnhem"));
    }

    @PreDestroy
    public void destroy() {

    }

}
