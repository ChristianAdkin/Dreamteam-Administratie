package com.dreamteam.payd.administration.dao.JPA.auth;

import com.dreamteam.payd.administration.dao.JPA.BaseDaoJPA;
import com.dreamteam.payd.administration.dao.auth.RoleDao;
import com.dreamteam.payd.administration.model.auth.Role;

import javax.ejb.Stateless;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
@Stateless
public class RoleDaoJPA extends BaseDaoJPA<Role> implements RoleDao {
    @Override
    public Role findByString(String roleName) {
        return getSingleResult(entityManager.createQuery("SELECT r FROM Role r " +
                "WHERE r.name LIKE :role", Role.class)
                .setParameter("role", roleName)
                .getResultList());
    }
}
