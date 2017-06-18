package com.camhub.antiochschool.service;

/**
 * Created by darith on 6/17/17.
 */
public interface ObserverSubject<T> {
    public void attach(T observer);
    public void detach(T observer);
    public void notifyObservers();
}
