package com.dreamteam.payd.administration.model;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public enum FuelType {
    GASOLINE(1.0),
    DIESEL(1.5),
    BIOFUEL(0.8),
    HYBRID(0.5),
    ELECTRIC(0.2),
    LPG(0.9);

    private double multiplier;

    FuelType(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
