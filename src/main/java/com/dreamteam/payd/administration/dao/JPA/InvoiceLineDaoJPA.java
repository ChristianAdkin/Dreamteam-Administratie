package com.dreamteam.payd.administration.dao.JPA;

import com.dreamteam.payd.administration.dao.InvoiceLineDao;
import com.dreamteam.payd.administration.model.InvoiceLine;

import javax.ejb.Stateless;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
@Stateless
public class InvoiceLineDaoJPA extends BaseDaoJPA<InvoiceLine> implements InvoiceLineDao {
}
