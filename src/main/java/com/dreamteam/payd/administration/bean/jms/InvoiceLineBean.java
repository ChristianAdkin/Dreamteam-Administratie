package com.dreamteam.payd.administration.bean.jms;

import com.dreamteam.payd.administration.bean.jms.dto.InvoiceLineDto;
import com.google.gson.Gson;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by hein on 5/23/17.
 */
@MessageDriven(name = "invoicebean", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/invoice"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "invoiceQueue"),
        @ActivationConfigProperty(propertyName = "resourceAdapter", propertyValue = "activemq-rar-5.14.5")
})
public class InvoiceLineBean implements MessageListener {

    @Inject
    private InvoiceDtoHandler invoiceDtoHandler;

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                String invoiceLineJson = ((TextMessage) message).getText();
                Gson gson = new Gson();
                InvoiceLineDto invoiceLineDto = gson.fromJson(invoiceLineJson, InvoiceLineDto.class);
                invoiceDtoHandler.convertAndSaveInvoiceLineDto(invoiceLineDto);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
