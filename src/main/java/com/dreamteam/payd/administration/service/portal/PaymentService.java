package com.dreamteam.payd.administration.service.portal;

import com.dreamteam.payd.administration.model.Day;
import com.dreamteam.payd.administration.model.Invoice;
import com.dreamteam.payd.administration.model.InvoiceStatus;
import com.dreamteam.payd.administration.model.Route;

import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
public interface PaymentService {
    /**
     * Retrieve all Invoice's for a given user id
     *
     * @param userId The Id to identify the user.
     * @return A list of all Invoice's of the user.
     */
    List<Invoice> getAllInvoicesOfUser(Long userId);

    List<Invoice> getLastFiveInvoicesOfUser(Long userId);

    /**
     * Retrieve all Day's for a given invoice id
     *
     * @param invoiceId The Id of the Invoice.
     * @return A list of all Day's from an invoice.
     */
    List<Day> getInvoiceDaysOfInvoice(Long invoiceId);

    /**
     * Retrieve all Route's for a given invoiceDay id
     *
     * @param invoiceDayId The Id of the Invoice.
     * @return A list of all Route's from a day.
     */
    List<Route> getInvoiceRoutesOfDay(Long invoiceDayId);

    /**
     * Get the amount of open invoices by the given user id
     *
     * @param userId The Id to identify the user.
     * @return Long, the amount of open invoices of the given user
     */
    Long getAmountOfOpenInvoicesOfUser(Long userId);

    void updateInvoice(Long invoiceId, InvoiceStatus status);

    Invoice getInvoiceById(Long invoiceId);
}
