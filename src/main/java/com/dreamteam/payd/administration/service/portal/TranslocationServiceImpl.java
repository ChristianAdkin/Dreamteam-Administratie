package com.dreamteam.payd.administration.service.portal;

import com.dreamteam.payd.administration.api.portal.DTO.CoordinateDTO;
import com.dreamteam.payd.administration.dao.CarDao;
import com.dreamteam.payd.administration.dao.InvoiceDao;
import com.dreamteam.payd.administration.model.Car;
import com.dreamteam.payd.administration.model.Day;
import com.dreamteam.payd.administration.model.Invoice;
import com.dreamteam.payd.administration.model.InvoiceLine;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Christian Adkin on 04/04/2017.
 */
@Stateless
public class TranslocationServiceImpl implements TranslocationService {

    @Inject
    private CarDao carDao;

    @Inject
    private InvoiceDao invoiceDao;

    @Override
    public Car getCarById(Long id) {
        return carDao.findById(id);
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getAll();
    }

    @Override
    public List<Car> getCarsByUser(Long userId) {
        return this.carDao.getCarsByUser(userId);
    }

    @Override
    public List<CoordinateDTO> getCoordinateDtosOfRoute(Long routeId) {return this.carDao.getCoordinatesOfRoute(routeId);
    }

    @Override
    public Double getAmountOfDrivenKmTodayOfUser(Long userId) {
        List<Invoice> invoices = invoiceDao.findByUser(userId);
        invoices = sortInvoices(invoices);

        List<InvoiceLine> invoiceLines = invoices.get(0).getInvoiceLines();
        invoiceLines= sortInvoiceLines(invoiceLines);

        return invoiceLines.get(0).getDistance();
    }

    @Override
    public Double getAmountOfDrivenKmMonthOfUser(Long userId) {
        List<Invoice> invoices = invoiceDao.findByUser(userId);
        invoices = sortInvoices(invoices);

        double distance = 0;

        List<InvoiceLine> invoiceLines = invoices.get(0).getInvoiceLines();

        for (InvoiceLine line : invoiceLines) {
            distance += line.getDistance();
        }

        return distance;
    }

    @Override
    public List<Day> getRecentDrivenDaysOfUser(Long userId) {
        throw new NotImplementedException();
    }

    @Override
    public Long getAmountOfVehiclesOfUser(Long userId) {
        throw new NotImplementedException();
    }

    private List<Invoice> sortInvoices(List<Invoice> invoices) {
        invoices.sort((o1, o2) -> {
            if (o1.getDateOfInvoice().before(o2.getDateOfInvoice())) {
                return -1;
            } else if (o1.getDateOfInvoice().after(o2.getDateOfInvoice())) {
                return 1;
            }
            return 0;
        });
        return invoices;
    }

    private List<InvoiceLine> sortInvoiceLines(List<InvoiceLine> invoiceLines) {
        invoiceLines.sort((o1, o2) -> {
            if (o1.getDay().getDayDate().before(o2.getDay().getDayDate())) {
                return -1;
            } else if (o1.getDay().getDayDate().before(o2.getDay().getDayDate())) {
                return 1;
            }
            return 0;
        });

        return invoiceLines;
    }
}