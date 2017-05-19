package com.dreamteam.payd.administration.dao.JPA;

import com.dreamteam.payd.administration.dao.InvoiceDao;
import com.dreamteam.payd.administration.model.Invoice;

import javax.ejb.Stateless;
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
}
