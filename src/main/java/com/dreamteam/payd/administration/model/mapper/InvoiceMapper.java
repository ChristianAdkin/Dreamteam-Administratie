package com.dreamteam.payd.administration.model.mapper;

import com.dreamteam.payd.administration.api.police.DTO.OwnershipDTO;
import com.dreamteam.payd.administration.api.portal.DTO.InvoiceDTO;
import com.dreamteam.payd.administration.model.Invoice;
import com.dreamteam.payd.administration.model.Ownership;
import com.dreamteam.payd.administration.util.BaseMapperUtil;

/**
 * Created by Christian Adkin on 19/05/2017.
 */
public class InvoiceMapper extends BaseMapperUtil<Invoice, InvoiceDTO> {

    @Override
    public InvoiceDTO to(Invoice invoice) {
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setId(invoice.getId());
        invoiceDTO.setDate(invoice.getDateOfInvoice());
        invoiceDTO.setStatus(invoice.getInvoiceStatus());
        invoiceDTO.setTotalPrice(invoice.getTotalPrice().longValue());
        return invoiceDTO;
    }
}
