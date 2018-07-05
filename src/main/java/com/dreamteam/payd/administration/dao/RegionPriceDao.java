package com.dreamteam.payd.administration.dao;

import com.dreamteam.payd.administration.model.Region;
import com.dreamteam.payd.administration.model.RegionPrice;

import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
public interface RegionPriceDao extends BaseDao<RegionPrice> {

    RegionPrice getCurrentRegionPrice(Region region);

}
