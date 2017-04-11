package com.dreamteam.payd.administration.dao.JPA;

import com.dreamteam.payd.administration.dao.RegionPriceDao;
import com.dreamteam.payd.administration.model.Region;
import com.dreamteam.payd.administration.model.RegionPrice;

import javax.ejb.Stateless;
import java.util.Date;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
@Stateless
public class RegionPriceDaoJPA extends BaseDaoJPA<RegionPrice> implements RegionPriceDao {

    @Override
    public RegionPrice getCurrentRegionPrice(Region region) {
        return entityManager.createQuery("SELECT rp FROM RegionPrice rp WHERE rp.startDate < :currentDate AND rp.endDate >= :currentDate AND rp.region = :region", RegionPrice.class)
                .setParameter("currentDate", new Date())
                .setParameter("region", region)
                .getSingleResult();
    }

}
