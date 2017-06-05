package com.dreamteam.payd.administration.bean.billing.invoice;

import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Invoice;
import com.dreamteam.payd.administration.service.internal.PaymentReviewService;
import com.dreamteam.payd.administration.util.ContextUtil;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Christian Adkin on 05/06/2017.
 */
@Named
@ViewScoped
public class InvoiceOverviewBean implements Serializable {

    @Inject
    private PaymentReviewService paymentReviewService;

    private List<Invoice> queriedInvoices;
    private String query;

    public void init() {
        if (!ContextUtil.isAjaxRequest(FacesContext.getCurrentInstance())) {
            this.construct();
        }
    }

    private void construct() {

    }

    public List<Invoice> findMatchingInvoice() {
        this.queriedInvoices = paymentReviewService.queryInvoices(query);
        return this.queriedInvoices;
    }

    public List<Invoice> getQueriedInvoices() {
        return queriedInvoices;
    }

    public void setQueriedInvoices(List<Invoice> queriedInvoices) {
        this.queriedInvoices = queriedInvoices;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
