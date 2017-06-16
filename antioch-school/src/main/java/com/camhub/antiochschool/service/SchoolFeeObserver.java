package com.camhub.antiochschool.service;

/**
 * Created by darith on 6/15/17.
 */
public interface SchoolFeeObserver {
    public void update(Double tuitionFee, Double adminstrationFee, Double supplyFee);
}
