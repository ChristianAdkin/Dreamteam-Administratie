package com.dreamteam.payd.administration.service.portal;

import com.dreamteam.payd.administration.model.Invoice;

import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
public interface PaymentService {
    List<Invoice> getInvoicesByUser(Long userId);
}
