package com.dreamteam.payd.administration.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public abstract class BaseMapperUtil<T, S> {

    public abstract S to (T entity);

    public List<S> to(List<T> froms) {
        return froms.stream().map(this::to).collect(Collectors.toList());
    }
}
