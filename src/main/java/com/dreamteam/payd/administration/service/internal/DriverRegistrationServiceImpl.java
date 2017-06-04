package com.dreamteam.payd.administration.service.internal;

import com.dreamteam.payd.administration.dao.CitizenDao;
import com.dreamteam.payd.administration.dao.auth.UserDao;
import com.dreamteam.payd.administration.model.Citizen;
import com.dreamteam.payd.administration.model.auth.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Christian Adkin on 28/03/2017.
 */
@Stateless
public class DriverRegistrationServiceImpl implements DriverRegistrationService {

    @Inject
    private CitizenDao citizenDao;
    @Inject
    private UserDao userDao;

    @Override
    public List<Citizen> queryCitizensByDetails(String query) {
        return citizenDao.queryByDetails(query);
    }

    @Override
    public Citizen findCitizenById(Long citizenId) {
        return citizenDao.findById(citizenId);
    }
}
