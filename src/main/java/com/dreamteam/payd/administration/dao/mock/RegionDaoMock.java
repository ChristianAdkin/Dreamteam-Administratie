package com.dreamteam.payd.administration.dao.mock;

import com.dreamteam.payd.administration.dao.RegionDao;
import com.dreamteam.payd.administration.dao.qualifier.CollectionMock;
import com.dreamteam.payd.administration.model.Region;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Christian Adkin on 11/04/2017.
 */
@Stateless
@CollectionMock
public class RegionDaoMock implements RegionDao {

    private Long nextId;
    private List<Region> regions;

    public RegionDaoMock() {
        regions = new ArrayList<>();
    }

    @Override
    public Region create(Region entity) {
        if (nextId == null) {
            nextId = 0L;
        }
        entity.setId(nextId++);
        regions.add(entity);
        return entity;
    }

    @Override
    public Region update(Region entity) {
        Region oldRegion = findById(entity.getId());
        int index = regions.indexOf(oldRegion);
        regions.set(index, entity);
        return entity;
    }

    @Override
    public void remove(Region entity) {
        Region regionToRemove = findById(entity.getId());
        regions.remove(regionToRemove);
    }

    @Override
    public void flush() {
    }

    @Override
    public Region findById(Long id) {
        for (Region region : regions) {
            if (region.getId().equals(id)) {
                return region;
            }
        }
        return null;
    }

    @Override
    public List<Region> getAll() {
        return Collections.unmodifiableList(regions);
    }
}
