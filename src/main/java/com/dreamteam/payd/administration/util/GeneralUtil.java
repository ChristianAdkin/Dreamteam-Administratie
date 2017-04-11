package com.dreamteam.payd.administration.util;

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

}
