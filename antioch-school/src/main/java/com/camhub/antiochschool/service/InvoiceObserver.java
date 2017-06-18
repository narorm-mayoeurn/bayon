package com.camhub.antiochschool.service;

import com.camhub.antiochschool.domain.Invoice;

/**
 * Created by darith on 6/15/17.
 */
public interface InvoiceObserver {
    public void updateInvoice(Invoice invoice);
}
