package com.dreamteam.payd.administration.model.mapper;

import com.dreamteam.payd.administration.api.police.DTO.OwnershipDTO;
import com.dreamteam.payd.administration.model.Ownership;
import com.dreamteam.payd.administration.util.BaseMapperUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public class OwnershipMapper extends BaseMapperUtil<Ownership, OwnershipDTO> {

    @Override
    public OwnershipDTO to(Ownership ownership) {
        OwnershipDTO ownershipDTO = new OwnershipDTO();
        ownershipDTO.setCarDTO(new CarMapper().to(ownership.getOwned()));
        ownershipDTO.setCitizenDTO(new CitizenMapper().to(ownership.getOwner()));
        ownershipDTO.setStartOwnership(ownership.getStartOwnership());
        ownershipDTO.setEndOwnership(ownership.getEndOwnership());
        return ownershipDTO;
    }
}
