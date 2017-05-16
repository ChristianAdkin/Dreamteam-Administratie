package com.dreamteam.payd.administration.api.portal.DTO;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public class DailyStatsDTO {

    private int driventoday;
    private int drivenmonth;
    private int ownedvehicles;
    private int openinvoices;

    public DailyStatsDTO(int driventoday, int drivenmonth, int ownedvehicles, int openinvoices) {
        this.driventoday = driventoday;
        this.drivenmonth = drivenmonth;
        this.ownedvehicles = ownedvehicles;
        this.openinvoices = openinvoices;
    }

    public int getDriventoday() {
        return driventoday;
    }

    public void setDriventoday(int driventoday) {
        this.driventoday = driventoday;
    }

    public int getDrivenmonth() {
        return drivenmonth;
    }

    public void setDrivenmonth(int drivenmonth) {
        this.drivenmonth = drivenmonth;
    }

    public int getOwnedvehicles() {
        return ownedvehicles;
    }

    public void setOwnedvehicles(int ownedvehicles) {
        this.ownedvehicles = ownedvehicles;
    }

    public int getOpeninvoices() {
        return openinvoices;
    }

    public void setOpeninvoices(int openinvoices) {
        this.openinvoices = openinvoices;
    }
}
