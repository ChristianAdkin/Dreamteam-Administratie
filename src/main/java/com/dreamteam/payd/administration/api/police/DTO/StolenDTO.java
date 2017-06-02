package com.dreamteam.payd.administration.api.police.DTO;

import com.dreamteam.payd.administration.api.shared.CarDTO;
import com.dreamteam.payd.administration.model.CarStatus;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public class StolenDTO {

    private CarDTO carDTO;
    private String carStatus;
    private String comments;

    public StolenDTO(CarDTO carDTO, String carStatus, String comments) {
        this.carDTO = carDTO;
        this.carStatus = carStatus;
        this.comments = comments;
    }

    public CarDTO getCarDTO() {
        return carDTO;
    }

    public void setCarDTO(CarDTO carDTO) {
        this.carDTO = carDTO;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
