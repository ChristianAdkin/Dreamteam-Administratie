package com.dreamteam.payd.administration.service.internal;

import com.dreamteam.payd.administration.model.Invoice;

import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
public interface PaymentReviewService {
    List<Invoice> queryInvoices(String query);

    Invoice getInvoiceById(Long invoiceId);
}
