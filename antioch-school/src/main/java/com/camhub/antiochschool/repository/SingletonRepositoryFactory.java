package com.camhub.antiochschool.repository;

/**
 * Created by Chandara Leang on 6/16/2017.
 */
public class SingletonRepositoryFactory implements RepositoryFactory {

    private final static RepositoryFactory INSTANCE = new SingletonRepositoryFactory();

    private ClassRepository classRepository = new ClassRepositoryImpl();
    private StudentRepository studentRepository = new StudentRepositoryImpl();
    private TeacherRepository teacherRepository = new TeacherRepositoryImpl();
    private PayrollRepository payrollRepository = new PayrollRepositoryImpl();
    private ProgramRepository programRepository = new ProgramRepositoryImpl();

    private SingletonRepositoryFactory(){

    }

    public static RepositoryFactory getFactory(){
        return INSTANCE;
    }

    @Override
    public ClassRepository getClassRepository() {
        return classRepository;
    }

    @Override
    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    @Override
    public TeacherRepository getTeacherRepository() { return teacherRepository; }

    @Override
    public PayrollRepository getPayrollRepository() { return payrollRepository; }

    @Override
    public ProgramRepository getProgramRepository() {
        return programRepository;
    }
}
