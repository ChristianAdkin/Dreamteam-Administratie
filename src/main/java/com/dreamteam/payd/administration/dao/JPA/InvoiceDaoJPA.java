package com.dreamteam.payd.administration.dao.JPA;

import com.dreamteam.payd.administration.dao.InvoiceDao;
import com.dreamteam.payd.administration.model.CarStatus;
import com.dreamteam.payd.administration.model.Invoice;
import com.dreamteam.payd.administration.model.InvoiceStatus;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
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
            foundInvoice = entityManager.createQuery("SELECT i FROM Invoice i WHERE i.car.cartracker.ICAN = :ican AND i.invoiceStatus = :status", Invoice.class)
                    .setParameter("ican", ICAN)
                    .setParameter("status", InvoiceStatus.INCOMPLETE)
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

    public List<Invoice> getLastFiveInvoicesByUser(Long userId) {
        //TODO: Make the query return only the invoices of the last 5 months
        return entityManager.createQuery("SELECT i FROM Invoice i WHERE i.citizen.user.id = :userId", Invoice.class).setParameter("userId", userId).getResultList();
    }

    @Override
    public Long getAmountOpenInvoicesOfUser(Long userId) {
         return entityManager.createQuery("SELECT COUNT(i) FROM Invoice i WHERE i.citizen.user.id = :userId AND i.invoiceStatus = :status", Long.class)
                .setParameter("userId", userId)
                .setParameter("status", InvoiceStatus.OPEN)
                .getSingleResult();
    }

    @Override
    public List<Invoice> query(String query) {
        Query q = entityManager.createNativeQuery("SELECT * FROM INVOICE i WHERE CAST(i.id AS CHAR(50)) LIKE ?1 OR i.invoiceStatus LIKE ?1", Invoice.class);
        q.setParameter(1, "%" + query + "%");
        return q.getResultList();
    }

    @Override
    public void updateInvoiceStatusToOpen() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Invoice> updateCriteria = criteriaBuilder.createCriteriaUpdate(Invoice.class);
        Root<Invoice> invoice = updateCriteria.from(Invoice.class);
        // update the status of an invoice
        updateCriteria.set(invoice.get("status"), InvoiceStatus.OPEN);
        // where the status of an invoice was incomplete
        updateCriteria.where(criteriaBuilder.equal(invoice.get("status"), InvoiceStatus.INCOMPLETE));
        int updatedInvoices = entityManager.createQuery(updateCriteria).executeUpdate();
        System.out.println("Number of updated invoices: " + updatedInvoices);
    }
}
