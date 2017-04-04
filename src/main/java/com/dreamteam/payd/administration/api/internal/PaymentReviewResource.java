package com.dreamteam.payd.administration.api.internal;

import com.dreamteam.payd.administration.service.internal.PaymentReviewService;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by Christian Adkin on 04/04/2017.
 */
@Stateless
public class PaymentReviewResource {

    @Inject
    private PaymentReviewService paymentReviewService;
}
