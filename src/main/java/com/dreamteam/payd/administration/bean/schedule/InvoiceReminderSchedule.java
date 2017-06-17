package com.dreamteam.payd.administration.bean.schedule;

import com.dreamteam.payd.administration.service.internal.PaymentReviewService;

import javax.ejb.Schedule;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Christian Adkin on 17/06/2017.
 */
@Singleton
public class InvoiceReminderSchedule {

    @Inject
    private PaymentReviewService paymentReviewService;

    @Schedule
    public void sendPaymentReminders() {
        paymentReviewService.sendPaymentReminders();
    }
}
