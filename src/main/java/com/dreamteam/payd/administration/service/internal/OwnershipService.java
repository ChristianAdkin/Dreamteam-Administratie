package com.dreamteam.payd.administration.service.internal;

import com.dreamteam.payd.administration.dao.OwnershipDao;
import com.dreamteam.payd.administration.model.Ownership;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by Loci on 2-6-2017.
 */
@Stateless
public class OwnershipService {

    @Inject
    private OwnershipDao ownershipDao;

    public Ownership findCurrentOwnershipByICAN(String ICAN) {
        return ownershipDao.findCurrentCarAndCitizenByIcan(ICAN);
    }
}
