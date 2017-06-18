package com.camhub.antiochschool.repository;

import com.camhub.antiochschool.domain.Invoice;
import com.camhub.antiochschool.service.ObserverSubject;
import com.camhub.antiochschool.service.InvoiceObserver;
import org.bayon.ogm.datastore.DatastoreRepositoryAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chandara Leang on 6/16/2017.
 */
public class InvoiceRepositoryImpl extends DatastoreRepositoryAdapter<Invoice> implements InvoiceRepository, ObserverSubject<InvoiceObserver> {

    private Invoice invoice;
    private List<InvoiceObserver> observers = new ArrayList<>();

    InvoiceRepositoryImpl(){

    }

    @Override
    public synchronized void remove(Long id) {
        invoice = findById(id);
        invoice.setArchived(true);
        update(invoice);
        notifyObservers();
    }

    @Override
    public void attach(InvoiceObserver observer) {
        if(!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(InvoiceObserver observer) {
        if(observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for(InvoiceObserver observer : observers) {
            observer.updateInvoice(invoice);
        }
    }
}
