package com.dreamteam.payd.administration.model.mapper;

import com.dreamteam.payd.administration.api.shared.UserDTO;
import com.dreamteam.payd.administration.model.Citizen;
import com.dreamteam.payd.administration.util.BaseMapperUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public class CitizenMapper extends BaseMapperUtil<Citizen, UserDTO> {

    @Override
    public UserDTO to(Citizen citizen) {
        UserDTO userDTO = new UserDTO();
        userDTO.setIdNumber(citizen.getIdNumber());
        userDTO.setInitials(citizen.getInitials());
        userDTO.setFirstname(citizen.getFirstName());
        userDTO.setPreposition(citizen.getPreposition());
        userDTO.setLastname(citizen.getLastName());
        if (citizen.getUser() != null) {
            userDTO.setEmail(citizen.getUser().getEmailAddress());
            userDTO.setId(citizen.getUser().getId());
        }
        userDTO.setDateofbirth(citizen.getDateOfBirth());
        return userDTO;
    }
}
