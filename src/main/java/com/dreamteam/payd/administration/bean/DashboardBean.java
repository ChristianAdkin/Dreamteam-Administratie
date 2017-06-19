package com.dreamteam.payd.administration.bean;

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
 * Created by Christian Adkin on 17/06/2017.
 */
@Named
@ViewScoped
public class DashboardBean implements Serializable {

    @Inject
    private PaymentReviewService paymentReviewService;

    private List<Invoice> overdueInvoices;

    public void init() {
        if (!ContextUtil.isAjaxRequest(FacesContext.getCurrentInstance())) {
            this.construct();
        }
    }

    private void construct() {
        this.overdueInvoices = this.paymentReviewService.getOverdueInvoices();
    }

    public List<Invoice> getOverdueInvoices() {
        return overdueInvoices;
    }

    public void setOverdueInvoices(List<Invoice> overdueInvoices) {
        this.overdueInvoices = overdueInvoices;
    }
}
