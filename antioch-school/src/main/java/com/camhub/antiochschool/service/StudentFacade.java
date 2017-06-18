package com.camhub.antiochschool.service;

import com.camhub.antiochschool.domain.Payroll;
import com.camhub.antiochschool.domain.Student;
import com.camhub.antiochschool.repository.PayrollRepository;
import com.camhub.antiochschool.repository.SingletonRepositoryFactory;
import com.camhub.antiochschool.repository.StudentRepository;
import com.camhub.antiochschool.repository.StudentRepositoryImpl;
import org.bayon.ogm.datastore.query.Page;
import org.bayon.ogm.datastore.query.QueryBuilder;

/**
 * Created by darith on 6/15/17.
 */
public class StudentFacade {
    private static final StudentFacade INSTANCE = new StudentFacade();

    private StudentRepository studentRepository;
    private PayrollRepository payrollRepository;

    public static StudentFacade getInstance() {
        return INSTANCE;
    }

    private StudentFacade() {
        studentRepository = SingletonRepositoryFactory.getFactory().getStudentRepository();
        payrollRepository = SingletonRepositoryFactory.getFactory().getPayrollRepository();
    }

    public Page<Student> getStudents(int offset, int limit) {
        QueryBuilder builder = studentRepository.createQueryBuilder();
        return studentRepository.find(builder.toQuery(), offset, limit);
    }

    public void update(Student student) {
        studentRepository.update(student);
    }

    public Long create(Student student) {
        return studentRepository.create(student);
    }

    public void delete(Long id) { studentRepository.remove(id);}

    public Page<Payroll> getPayrolls(int offset, int limit) {
        QueryBuilder builder = payrollRepository.createQueryBuilder();
        return payrollRepository.find(builder.toQuery(), offset, limit);
    }

    public void update(Payroll payroll) { payrollRepository.update(payroll); }

    public Long create(Payroll payroll) { return payrollRepository.create(payroll); }

    public void deletePayroll(Long id){ payrollRepository.remove(id); }

    public Payroll getPayrollById(Long id) { return payrollRepository.findById(id); }


    public boolean isPaid(Student student) {
        if(student.getPayRollId() == null) return false;


    }
}
