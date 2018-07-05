package com.dreamteam.payd.administration.dao.auth;

import com.dreamteam.payd.administration.api.authentication.AuthenticationException;
import com.dreamteam.payd.administration.dao.BaseDao;
import com.dreamteam.payd.administration.model.auth.User;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
public interface UserDao extends BaseDao<User> {
    void authenticate(String username, String password) throws AuthenticationException;
}
