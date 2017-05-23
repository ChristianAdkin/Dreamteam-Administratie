package com.dreamteam.payd.administration.util;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Christian Adkin on 23/05/2017.
 */
public class DateUtil {

    public static Date from (LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
