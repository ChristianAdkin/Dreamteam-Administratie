package com.dreamteam.payd.administration.dao;

import com.dreamteam.payd.administration.model.Citizen;

import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
public interface CitizenDao extends BaseDao<Citizen> {
    Citizen findByEmail(String email);

    List<Citizen> queryByDetails(String query);

    Citizen findByCSN(String csn);
}
