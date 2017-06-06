package com.dreamteam.payd.administration.bean.billing.invoice;

import com.dreamteam.payd.administration.model.Invoice;
import com.dreamteam.payd.administration.model.InvoiceStatus;
import com.dreamteam.payd.administration.service.internal.PaymentReviewService;
import com.dreamteam.payd.administration.util.ContextUtil;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Christian Adkin on 05/06/2017.
 */
@Named
@ViewScoped
public class SelectedInvoiceBean implements Serializable {

    @Inject
    private PaymentReviewService paymentReviewService;

    private Long invoiceId;
    private Invoice invoice;

    public void init() {
        if (!ContextUtil.isAjaxRequest(FacesContext.getCurrentInstance())) {
            this.invoice = this.paymentReviewService.getInvoiceById(this.invoiceId);
            this.construct();
        }
    }

    private void construct() {

    }

    public void closeInvoice() {
        this.invoice.setInvoiceStatus(InvoiceStatus.CLOSED);
        this.invoice = this.paymentReviewService.updateInvoice(this.invoice);
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
