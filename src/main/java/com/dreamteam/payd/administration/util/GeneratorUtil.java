package com.dreamteam.payd.administration.util;

import java.util.Random;

/**
 * Created by hein on 6/13/17.
 */
public class GeneratorUtil {

    public static String createRandomID() {
        Random random = new Random(System.currentTimeMillis());
        long randomLong = random.nextLong();
        return Long.toHexString(randomLong);
    }
}
