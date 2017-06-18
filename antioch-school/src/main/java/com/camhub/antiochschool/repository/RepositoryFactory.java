package com.camhub.antiochschool.repository;

/**
 * Created by Chandara Leang on 6/16/2017.
 */
public interface RepositoryFactory {

    ClassRepository getClassRepository();
    StudentRepository getStudentRepository();
    TeacherRepository getTeacherRepository();
    InvoiceRepository getInvoiceRepository();
    ProgramRepository getProgramRepository();
}
