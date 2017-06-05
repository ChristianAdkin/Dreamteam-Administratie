package com.dreamteam.payd.administration.dao;

import com.dreamteam.payd.administration.model.Cartracker;

import java.util.List;

/**
 * Created by Christian Adkin on 02/05/2017.
 */
public interface CartrackerDao extends BaseDao<Cartracker> {
    List<Cartracker> queryByICAN(String query);
}
