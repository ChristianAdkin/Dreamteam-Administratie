package com.dreamteam.payd.administration.service.internal;

import com.dreamteam.payd.administration.dao.RegionDao;
import com.dreamteam.payd.administration.dao.qualifier.JPA;
import com.dreamteam.payd.administration.dao.qualifier.REST;
import com.dreamteam.payd.administration.model.Region;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Christian Adkin on 04/04/2017.
 */
@Stateless
public class RegionServiceImpl implements RegionService {

    @Inject
    @REST
    private RegionDao regionDao;

    @Override
    public List<Region> getAll() {
        return regionDao.getAll();
    }
}
