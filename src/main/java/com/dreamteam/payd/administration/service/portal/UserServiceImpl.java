package com.dreamteam.payd.administration.service.portal;

import com.dreamteam.payd.administration.api.authentication.AuthenticationException;
import com.dreamteam.payd.administration.dao.CitizenDao;
import com.dreamteam.payd.administration.dao.auth.UserDao;
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

    @Inject
    private UserDao userDao;

    @Override
    public Citizen getByEmail(String email) {
        return citizenDao.findByEmail(email);
    }

    @Override
    public void authenticate(String username, String password) throws AuthenticationException {
        userDao.authenticate(username, password);
    }
}
