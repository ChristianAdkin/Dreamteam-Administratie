package com.dreamteam.payd.administration.service.internal;

import com.dreamteam.payd.administration.dao.InvoiceDao;
import com.dreamteam.payd.administration.model.Invoice;

import javax.ejb.Stateless;
import javax.inject.Inject;
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
}
