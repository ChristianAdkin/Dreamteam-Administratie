package com.dreamteam.payd.administration.util;

import java.util.List;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public interface MapperUtil<T, S> {

    S toDTO(T entity);
    List<S> toDTO(List<T> entities);

}
