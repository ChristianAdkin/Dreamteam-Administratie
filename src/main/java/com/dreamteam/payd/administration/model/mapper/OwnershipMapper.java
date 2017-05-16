package com.dreamteam.payd.administration.model.mapper;

import com.dreamteam.payd.administration.api.police.DTO.OwnershipDTO;
import com.dreamteam.payd.administration.model.Ownership;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public class OwnershipMapper {

    public static OwnershipDTO toDTO(Ownership ownership) {
        OwnershipDTO ownershipDTO = new OwnershipDTO();
        ownershipDTO.setCarDTO(CarMapper.toDTO(ownership.getOwned()));
        ownershipDTO.setCitizenDTO(CitizenMapper.toDTO(ownership.getOwner()));
        ownershipDTO.setStartOwnership(ownership.getStartOwnership());
        ownershipDTO.setEndOwnership(ownership.getEndOwnership());
        return ownershipDTO;
    }

    public static List<OwnershipDTO> toDTO (List<Ownership> ownerships) {
        List<OwnershipDTO> ownershipDTOS = new ArrayList<>();
        for (Ownership ownership:ownerships) {
            ownershipDTOS.add(toDTO(ownership));
        }
        return ownershipDTOS;
    }
}
