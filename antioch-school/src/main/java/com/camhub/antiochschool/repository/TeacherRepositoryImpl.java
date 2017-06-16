package com.camhub.antiochschool.repository;

import com.camhub.antiochschool.domain.Teacher;
import org.bayon.ogm.datastore.DatastoreRepositoryAdapter;

/**
 * Created by Chandara Leang on 6/15/2017.
 */
public class TeacherRepositoryImpl extends DatastoreRepositoryAdapter<Teacher> implements TeacherRepository {

    TeacherRepositoryImpl() {
    }
}
