package com.dreamteam.payd.administration.service.portal;

import com.dreamteam.payd.administration.dao.CitizenDao;
import com.dreamteam.payd.administration.model.Citizen;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by Christian Adkin on 19/05/2017.
 */
@Stateless
public class UserServiceImpl implements UserService {

    @Inject
    private CitizenDao citizenDao;

    @Override
    public Citizen getByEmail(String email) {
        return citizenDao.findByEmail(email);
    }
}
