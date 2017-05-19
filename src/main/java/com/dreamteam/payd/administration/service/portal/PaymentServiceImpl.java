package com.dreamteam.payd.administration.service.portal;

import com.dreamteam.payd.administration.dao.InvoiceDao;
import com.dreamteam.payd.administration.model.Invoice;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Christian Adkin on 04/04/2017.
 */
@Stateless
public class PaymentServiceImpl implements PaymentService {

    @Inject
    private InvoiceDao invoiceDao;

    @Override
    public List<Invoice> getInvoicesByUser(Long userId) {
        return invoiceDao.findByUser(userId);
    }
}
