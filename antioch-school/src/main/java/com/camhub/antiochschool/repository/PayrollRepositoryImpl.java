package com.camhub.antiochschool.repository;

import com.camhub.antiochschool.domain.Payroll;
import org.bayon.ogm.datastore.DatastoreRepositoryAdapter;

/**
 * Created by Chandara Leang on 6/16/2017.
 */
public class PayrollRepositoryImpl extends DatastoreRepositoryAdapter<Payroll> implements PayrollRepository {

    PayrollRepositoryImpl(){

    }
}
