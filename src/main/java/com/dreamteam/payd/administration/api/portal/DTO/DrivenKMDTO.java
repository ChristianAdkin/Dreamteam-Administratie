package com.dreamteam.payd.administration.api.portal.DTO;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public class DrivenKMDTO {

    private int year;
    private int month;
    private int drivenkm;

    public DrivenKMDTO(int year, int month, int drivenkm) {
        this.year = year;
        this.month = month;
        this.drivenkm = drivenkm;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDrivenkm() {
        return drivenkm;
    }

    public void setDrivenkm(int drivenkm) {
        this.drivenkm = drivenkm;
    }
}
