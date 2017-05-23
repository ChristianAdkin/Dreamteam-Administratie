package com.dreamteam.payd.administration.service.police;

import com.dreamteam.payd.administration.util.DateUtil;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
public class CarServiceTest {
    @Test
    public void test() {
        Date date = DateUtil.from(LocalDateTime.of(1994, Month.NOVEMBER, 28, 0, 0));
        System.out.println(date);
    }
}
