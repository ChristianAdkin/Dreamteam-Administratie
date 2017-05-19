package com.dreamteam.payd.administration.dao;

import com.dreamteam.payd.administration.model.Invoice;

import java.util.List;

/**
 * Created by Christian Adkin on 21/03/2017.
 */
public interface InvoiceDao {
    List<Invoice> findByUser(Long userId);
}
