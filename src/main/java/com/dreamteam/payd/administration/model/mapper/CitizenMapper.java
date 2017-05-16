package com.dreamteam.payd.administration.model.mapper;

import com.dreamteam.payd.administration.api.shared.UserDTO;
import com.dreamteam.payd.administration.model.Citizen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public class CitizenMapper {

    public static UserDTO toDTO(Citizen citizen) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(citizen.getId());
        userDTO.setIdNumber(citizen.getIdNumber());
        userDTO.setInitials(citizen.getInitials());
        userDTO.setFirstname(citizen.getFirstName());
        userDTO.setPreposition(citizen.getPreposition());
        userDTO.setLastname(citizen.getLastName());
        userDTO.setEmail(citizen.getUser().getEmailAddress());
        userDTO.setDateofbirth(citizen.getDateOfBirth());
        return userDTO;
    }

    public static List<UserDTO> toDTO(List<Citizen> citizens) {
        List<UserDTO> userDTOS = new ArrayList<>();
        for (Citizen citizen:citizens) {
            userDTOS.add(toDTO(citizen));
        }
        return userDTOS;
    }

}
