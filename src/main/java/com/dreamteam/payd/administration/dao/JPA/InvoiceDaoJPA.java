package com.dreamteam.payd.administration.dao.JPA;

import com.dreamteam.payd.administration.dao.InvoiceDao;
import com.dreamteam.payd.administration.model.Invoice;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
@Stateless
public class InvoiceDaoJPA extends BaseDaoJPA<Invoice> implements InvoiceDao {
    @Override
    public List<Invoice> findByUser(Long userId) {
        return entityManager.createQuery("SELECT i FROM Invoice i WHERE i.citizen.user.id = :userId", Invoice.class).setParameter("userId", userId).getResultList();
    }

    @Override
    public Invoice findIncompleteInvoiceByIcan(String ICAN) {
        Invoice foundInvoice = null;
        try {
            foundInvoice = entityManager.createQuery("SELECT i FROM Invoice i WHERE i.car.cartracker.ICAN = :ican AND i.invoiceStatus = com.dreamteam.payd.administration.model.InvoiceStatus.INCOMPLETE", Invoice.class)
                    .setParameter("ican", ICAN)
                    .getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("No result found for " + ICAN + ", returning null");
        }
        return foundInvoice;
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        update(invoice);
    }
}
