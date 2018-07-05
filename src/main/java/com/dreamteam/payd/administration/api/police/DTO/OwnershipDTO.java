package com.dreamteam.payd.administration.api.police.DTO;

import com.dreamteam.payd.administration.api.shared.UserDTO;
import com.dreamteam.payd.administration.api.shared.CarDTO;

import java.util.Date;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public class OwnershipDTO {

    private CarDTO carDTO;
    private UserDTO citizenDTO;

    private Date startOwnership;
    private Date endOwnership;

    public OwnershipDTO() {

    }

    public OwnershipDTO(CarDTO carDTO, UserDTO citizenDTO, Date startOwnership, Date endOwnership) {
        this.carDTO = carDTO;
        this.citizenDTO = citizenDTO;
        this.startOwnership = startOwnership;
        this.endOwnership = endOwnership;
    }

    public CarDTO getCarDTO() {
        return carDTO;
    }

    public void setCarDTO(CarDTO carDTO) {
        this.carDTO = carDTO;
    }

    public UserDTO getCitizenDTO() {
        return citizenDTO;
    }

    public void setCitizenDTO(UserDTO citizenDTO) {
        this.citizenDTO = citizenDTO;
    }

    public Date getStartOwnership() {
        return startOwnership;
    }

    public void setStartOwnership(Date startOwnership) {
        this.startOwnership = startOwnership;
    }

    public Date getEndOwnership() {
        return endOwnership;
    }

    public void setEndOwnership(Date endOwnership) {
        this.endOwnership = endOwnership;
    }
}
