package com.dreamteam.payd.administration.service.internal;

import com.dreamteam.payd.administration.dao.InvoiceDao;
import com.dreamteam.payd.administration.model.Invoice;
import com.dreamteam.payd.administration.model.InvoiceStatus;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Created by Christian Adkin on 04/04/2017.
 */
@Stateless
public class PaymentReviewServiceImpl implements PaymentReviewService {

    @Inject
    private InvoiceDao invoiceDao;

    @Override
    public List<Invoice> queryInvoices(String query) {
        return invoiceDao.query(query);
    }

    @Override
    public Invoice getInvoiceById(Long invoiceId) {
        return this.invoiceDao.findById(invoiceId);
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        return this.invoiceDao.update(invoice);
    }

    @Override
    public List<Invoice> getOverdueInvoices() {
        return this.invoiceDao.getOverdueInvoices();
    }

    @Override
    public void sendPaymentReminders() {
        List<Invoice> overdueInvoices = this.getOverdueInvoices();
        for (Invoice invoice : overdueInvoices) {
            setPaymentReminder(invoice);
        }
    }

    public void setPaymentReminder(Invoice invoice) {
        invoice.setInvoiceStatus(InvoiceStatus.REMINDER);
        invoice.setDateOfInvoice(new Date());

        //TODO: AANMANING AANMAKEN.

        this.invoiceDao.update(invoice);
    }
}
