package com.dreamteam.payd.administration.api.portal;

import com.dreamteam.payd.administration.service.portal.PaymentService;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by Christian Adkin on 04/04/2017.
 */
@Stateless
public class PaymentResource {

    @Inject
    private PaymentService paymentService;
}
