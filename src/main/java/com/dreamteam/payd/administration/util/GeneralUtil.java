package com.dreamteam.payd.administration.util;

import java.util.List;
import java.util.Random;

/**
 * Created by Christian Adkin on 11/04/2017.
 */
public class GeneralUtil {

    public static boolean nullOrEmpty(String string) {
        if (string == null || string.isEmpty()) {
            return true;
        }
        return false;
    }

    public static <T> T getRandomElement(List<T> list) {
        return list.get(new Random().nextInt(list.size()));
    }

    public static <T> T removeRandomElement(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(new Random().nextInt(list.size()));
    }

}
