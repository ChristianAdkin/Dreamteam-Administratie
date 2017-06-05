package com.dreamteam.payd.administration.dao;

import com.dreamteam.payd.administration.model.Invoice;

import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
public interface InvoiceDao extends BaseDao<Invoice> {
    List<Invoice> findByUser(Long userId);

    Invoice findIncompleteInvoiceByIcan(String ICAN);

    void saveInvoice(Invoice invoice);

    List<Invoice> getLastFiveInvoicesByUser(Long userId);

    Long getAmountOpenInvoicesOfUser(Long userId);

    List<Invoice> query(String query);

    void updateInvoiceStatusToOpen();
}
