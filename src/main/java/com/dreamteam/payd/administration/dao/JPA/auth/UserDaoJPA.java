package com.dreamteam.payd.administration.dao.JPA.auth;

import com.dreamteam.payd.administration.api.authentication.AuthenticationException;
import com.dreamteam.payd.administration.dao.JPA.BaseDaoJPA;
import com.dreamteam.payd.administration.dao.auth.UserDao;
import com.dreamteam.payd.administration.model.auth.User;

import javax.ejb.Stateless;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
@Stateless
public class UserDaoJPA extends BaseDaoJPA<User> implements UserDao {

    @Override
    public void authenticate(String username, String password) throws AuthenticationException {
        User user = getSingleResult(entityManager.createQuery("SELECT u FROM User u WHERE u.emailAddress = :username AND u.password = :password", User.class).getResultList());
        if (user == null) {
            throw new AuthenticationException();
        }
    }
}
