package com.dreamteam.payd.administration.service.portal;

import com.dreamteam.payd.administration.dao.DayDao;
import com.dreamteam.payd.administration.dao.InvoiceDao;
import com.dreamteam.payd.administration.dao.InvoiceLineDao;
import com.dreamteam.payd.administration.model.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Christian Adkin on 04/04/2017.
 */
@Stateless
public class PaymentServiceImpl implements PaymentService {

    @Inject
    InvoiceDao invoiceDao;
    @Inject
    InvoiceLineDao invoiceLineDao;
    @Inject
    DayDao dayDao;

    @Override
    public List<Invoice> getAllInvoicesOfUser(Long userId) {
        return invoiceDao.findByUser(userId);
    }

    @Override
    public List<Invoice> getLastFiveInvoicesOfUser(Long userId) {
        return invoiceDao.getLastFiveInvoicesByUser(userId);
    }

    @Override
    public List<Day> getInvoiceDaysOfInvoice(Long invoiceId) {
        Invoice invoice = invoiceDao.findById(invoiceId);
        List<InvoiceLine> invoiceLines = invoice.getInvoiceLines();
        List<Day> days = new ArrayList<>();

        for (InvoiceLine line : invoiceLines){
            days.add(line.getDay());
        }
        return Collections.unmodifiableList(days);
    }

    @Override
    public List<Route> getInvoiceRoutesOfDay(Long invoiceDayId) {
        Day day = dayDao.findById(invoiceDayId);
        return Collections.unmodifiableList(day.getRoutes());
    }

    @Override
    public Long getAmountOfOpenInvoicesOfUser(Long userId) {
        return invoiceDao.getAmountOpenInvoicesOfUser(userId);
    }

    @Override
    public void updateInvoice(Long invoiceId, InvoiceStatus status) {
        Invoice currentInvoice = invoiceDao.findById(invoiceId);
        currentInvoice.setInvoiceStatus(status);
        invoiceDao.update(currentInvoice);
    }

    @Override
    public Invoice getInvoiceById(Long invoiceId) {
        return this.invoiceDao.findById(invoiceId);
    }
}
