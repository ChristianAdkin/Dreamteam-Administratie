package com.dreamteam.payd.administration.service.internal;

import com.dreamteam.payd.administration.dao.InvoiceDao;
import com.dreamteam.payd.administration.model.Invoice;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by Loci on 2-6-2017.
 */
@Stateless
public class InvoiceService {

    @Inject
    private InvoiceDao invoiceDao;

    public Invoice findIncompleteInvoiceByICAN(String ICAN) {
        return invoiceDao.findIncompleteInvoiceByIcan(ICAN);
    }

    public void saveInvoice(Invoice invoice) {
        invoiceDao.saveInvoice(invoice);
    }
}
