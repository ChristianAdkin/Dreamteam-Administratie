package com.dreamteam.payd.administration.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
@Entity
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus invoiceStatus;

    @ManyToOne
    private Citizen citizen;
    @ManyToOne
    private Car car;

    @OneToMany
    private List<InvoiceLine> invoiceLines;

    protected Invoice() {
        this.invoiceLines = new ArrayList<>();
    }

    public Invoice(Citizen citizen, Car car) {
        this();
        this.citizen = citizen;
        this.car = car;
    }

    public Invoice(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getFuelTax() {
        BigDecimal totalInvoicePrice = BigDecimal.ZERO;
        totalInvoicePrice = totalInvoicePrice.add(getTotalInvoiceLinePrice());
        BigDecimal fuelTax = calculateFuelTypeTax(totalInvoicePrice);
        return fuelTax;
    }

    public BigDecimal getPriceBeforeTax() {
        return getTotalInvoiceLinePrice();
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalInvoicePrice = BigDecimal.ZERO;
        totalInvoicePrice = totalInvoicePrice.add(getTotalInvoiceLinePrice());
        BigDecimal priceAfterFuelTax = totalInvoicePrice.add(calculateFuelTypeTax(totalInvoicePrice));
        return priceAfterFuelTax;
    }

    private BigDecimal getTotalInvoiceLinePrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (InvoiceLine invoiceLine : invoiceLines) {
            totalPrice = totalPrice.add(invoiceLine.getPrice());
        }
        return totalPrice;
    }

    private BigDecimal calculateFuelTypeTax(BigDecimal basePrice) {
        // Calculate the tax percentage that should be levied on a car, based on its car type
        // Ex: 1.0 becomes 0.01
        // Ex: 0.8 becomes 0.008
        BigDecimal multiplicand = new BigDecimal(this.car.getFuelType().getMultiplier() / 100);
        // Ex: If price equals 100, the calculation should perform 100 * 0.008
        //      This should result in the number 0.80.
        return basePrice.multiply(multiplicand);
    }
}
