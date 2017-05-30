package com.dreamteam.payd.administration.model.mapper;

import com.dreamteam.payd.administration.api.portal.DTO.DrivenKMDTO;
import com.dreamteam.payd.administration.model.Invoice;
import com.dreamteam.payd.administration.model.InvoiceLine;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mick on 29-5-2017.
 */
public class DrivenKmMapper {

    /*
    * Method maps invoices into DrivenKmDto's
    * @param invoices, List of Invoice, the last 5 invoices of a user (5 months)
     */
    public List<DrivenKMDTO> to(List<Invoice> invoices){
        List<DrivenKMDTO> createdDrivenKms = new ArrayList<>();
        for (Invoice invoice : invoices){
            int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(invoice.getDateOfInvoice()));
            int month = Integer.parseInt(new SimpleDateFormat("dd").format(invoice.getDateOfInvoice()));
            int drivenkm = 0;

            //calculate kilometers driven for this invoice
            for (InvoiceLine invoiceLine : invoice.getInvoiceLines()){
                drivenkm += invoiceLine.getDay().getDistance() / 1000;
            }

            DrivenKMDTO currentDto = new DrivenKMDTO(year, month, drivenkm);
            createdDrivenKms.add(currentDto);
        }
        return createdDrivenKms;
    }
}
