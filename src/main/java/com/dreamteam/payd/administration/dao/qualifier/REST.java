package com.dreamteam.payd.administration.dao.qualifier;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Created by hein on 6/5/17.
 */
@Qualifier
@Target({ TYPE, METHOD, FIELD, PARAMETER })
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface REST {
}
