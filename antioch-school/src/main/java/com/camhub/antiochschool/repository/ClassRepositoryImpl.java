package com.camhub.antiochschool.repository;

import com.camhub.antiochschool.domain.Classroom;
import org.bayon.ogm.datastore.DatastoreRepositoryAdapter;

/**
 * Created by nm on 9/6/17.
 */
public class ClassRepositoryImpl extends DatastoreRepositoryAdapter<Classroom> implements ClassRepository {

    ClassRepositoryImpl() {
    }
}
