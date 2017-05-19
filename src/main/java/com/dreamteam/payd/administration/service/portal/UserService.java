package com.dreamteam.payd.administration.service.portal;

import com.dreamteam.payd.administration.model.Citizen;

import java.util.List;

/**
 * Created by Christian Adkin on 19/05/2017.
 */
public interface UserService {
    Citizen getByEmail(String email);
}
