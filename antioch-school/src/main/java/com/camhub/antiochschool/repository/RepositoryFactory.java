package com.camhub.antiochschool.repository;

import org.bayon.ogm.datastore.DatastoreRepository;

/**
 * Created by Chandara Leang on 6/16/2017.
 */
public interface RepositoryFactory {

    ClassRepository getClassRepository();
    StudentRepository getStudentRepository();
    TeacherRepository getTeacherRepository();
    PayrollRepository getPayrollRepository();
}
