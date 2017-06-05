package com.dreamteam.payd.administration.jobs;

import com.dreamteam.payd.administration.dao.InvoiceDao;
import com.dreamteam.payd.administration.dao.qualifier.JPA;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 * Created by hein on 6/2/17.
 */
@Singleton
public class OpenInvoicesJob {

    @Inject @JPA
    InvoiceDao invoiceDao;

    @Schedule(dayOfMonth = "Last", hour = "23", minute = "59")
    public void makeAllInvoicesPayable() {
        invoiceDao.updateInvoiceStatusToOpen();
    }
}
