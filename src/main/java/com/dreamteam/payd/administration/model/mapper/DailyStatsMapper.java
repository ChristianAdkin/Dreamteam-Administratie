package com.dreamteam.payd.administration.model.mapper;

import com.dreamteam.payd.administration.api.portal.DTO.DailyStatsDTO;

/**
 * Created by Mick on 29-5-2017.
 */
public class DailyStatsMapper {

    public DailyStatsDTO create(int driventoday, int drivenmonth, int ownedvehicles, int openinvoices){
        return new DailyStatsDTO(driventoday, drivenmonth, ownedvehicles, openinvoices);
    }
}
