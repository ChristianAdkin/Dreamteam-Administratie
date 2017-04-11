package com.dreamteam.payd.administration.dao.JPA;

import com.dreamteam.payd.administration.dao.RegionDao;
import com.dreamteam.payd.administration.dao.qualifier.JPA;
import com.dreamteam.payd.administration.model.Region;

import javax.ejb.Stateless;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
@Stateless
@JPA
public class RegionDaoJPA extends BaseDaoJPA<Region> implements RegionDao {
}
