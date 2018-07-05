package com.dreamteam.payd.administration.bean.jms;

import com.dreamteam.payd.administration.bean.jms.dto.InvoiceLineDto;
import com.dreamteam.payd.administration.bean.jms.dto.InvoiceRegionDto;
import com.dreamteam.payd.administration.model.*;
import com.dreamteam.payd.administration.service.internal.InvoiceService;
import com.dreamteam.payd.administration.service.internal.OwnershipService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Loci on 2-6-2017.
 */
@Stateless
public class InvoiceDtoHandler {

    @Inject
    private InvoiceService invoiceService;

    @Inject
    private OwnershipService ownershipService;

    void convertAndSaveInvoiceLineDto(InvoiceLineDto invoiceLineDto) {
        /*
         Find car with correct ican;
         find invoice with ICAN && status == INCOMPLETE, or create new invoice
         */
        Invoice currentInvoice = invoiceService.findIncompleteInvoiceByICAN(invoiceLineDto.getICAN());

        if (currentInvoice == null) {
            createNewInvoiceWithInvoiceLine(invoiceLineDto);
        } else {
            addToExistingInvoice(invoiceLineDto, currentInvoice);
        }
    }

    private void createNewInvoiceWithInvoiceLine(InvoiceLineDto invoiceLineDto) {
        InvoiceLine invoiceLine = convertToInvoiceLine(invoiceLineDto);
        Ownership ownership = ownershipService.findCurrentOwnershipByICAN(invoiceLine.getICAN());

        if (ownership == null) {
            System.out.println("The correct ownership could not be found.");
            return;
        }

        Invoice invoice = new Invoice(ownership.getOwner(), ownership.getOwned());
        invoice.addInvoiceLine(invoiceLine);

        invoiceService.saveInvoice(invoice);
    }

    private void addToExistingInvoice(InvoiceLineDto invoiceLineDto, Invoice invoice) {
        InvoiceLine invoiceLine = convertToInvoiceLine(invoiceLineDto);
        invoice.addInvoiceLine(invoiceLine);

        invoiceService.saveInvoice(invoice);
    }

    private InvoiceLine convertToInvoiceLine(InvoiceLineDto invoiceLineDto) {
        InvoiceLine invoiceLine = new InvoiceLine();
        invoiceLine.setPrice(invoiceLineDto.getPrice());
        invoiceLine.setDistance(invoiceLineDto.getDistance());
        invoiceLine.setICAN(invoiceLineDto.getICAN());

        /*
        The routes are in a Day, and the regions are in a Route
         */
        Day day = new Day();
        day.setDayDate(invoiceLineDto.getDateOfInvoice());

        /*
        Now add all routes from invoiceLineDto in Day
         */
        List<Route> routes = new ArrayList<>();
        invoiceLineDto.getRoutes().forEach(routeDto -> {
            Route r = new Route(day);
            r.setId(routeDto.getRouteId());
            r.setDistance(routeDto.getDistance());
            r.setPrice(routeDto.getPrice());

            List<InvoiceRegion> invoiceRegions = new ArrayList<>();
            routeDto.getDrivenInRegions().forEach(regionDto -> {
                InvoiceRegion invoiceRegion = new InvoiceRegion(regionDto.getAreaCode(), regionDto.getName(), regionDto.getPrice(), regionDto.getDistance());
                invoiceRegions.add(invoiceRegion);
            });

            r.setInvoiceRegions(invoiceRegions);
            routes.add(r);
        });

        day.setRoutes(routes);
        invoiceLine.setDay(day);

        return invoiceLine;
    }
}
