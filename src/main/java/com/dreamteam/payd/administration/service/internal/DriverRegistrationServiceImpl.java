package com.dreamteam.payd.administration.service.internal;

import com.dreamteam.payd.administration.dao.auth.UserDao;
import com.dreamteam.payd.administration.model.auth.User;

import javax.inject.Inject;

/**
 * Created by Christian Adkin on 28/03/2017.
 */
public class DriverRegistrationServiceImpl implements DriverRegistrationService {

    @Inject
    private UserDao userDao;

    private void test() {
        User user = userDao.findById(1L);
    }
}
