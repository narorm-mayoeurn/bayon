package com.camhub.antiochschool.service;

import com.camhub.antiochschool.domain.Invoice;
import com.camhub.antiochschool.domain.Student;
import com.camhub.antiochschool.repository.InvoiceRepository;
import com.camhub.antiochschool.repository.SingletonRepositoryFactory;
import com.camhub.antiochschool.repository.StudentRepository;
import org.bayon.ogm.datastore.query.Page;
import org.bayon.ogm.datastore.query.QueryBuilder;

import java.util.Date;

/**
 * Created by darith on 6/15/17.
 */
public class StudentFacade {
    private static final StudentFacade INSTANCE = new StudentFacade();

    private StudentRepository studentRepository;
    private InvoiceRepository invoiceRepository;

    public static StudentFacade getInstance() {
        return INSTANCE;
    }

    private StudentFacade() {
        studentRepository = SingletonRepositoryFactory.getFactory().getStudentRepository();
        invoiceRepository = SingletonRepositoryFactory.getFactory().getInvoiceRepository();
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

    public Student get(Long id) { return studentRepository.findById(id);}

    public Page<Invoice> getPayrolls(int offset, int limit) {
        QueryBuilder builder = invoiceRepository.createQueryBuilder();
        return invoiceRepository.find(builder.toQuery(), offset, limit);
    }

    public void update(Invoice invoice) { invoiceRepository.update(invoice); }

    public Long create(Invoice invoice) { return invoiceRepository.create(invoice); }

    public void deletePayroll(Long id){
        invoiceRepository.remove(id);
    }

    public Invoice getPayrollById(Long id) { return invoiceRepository.findById(id); }


    public boolean isPaid(Student student) {
        if(student.getInvoiceId() == null) return false;

        Invoice invoice = invoiceRepository.findById(student.getInvoiceId());
        if(invoice == null || invoice.getArchived() == true || invoice.getEndDate() == null) return false;

        Date now = new Date();
        System.out.println(invoice.getEndDate().getTime() - now.getTime());
        return invoice.getEndDate().getTime() - now.getTime() > 0;
    }
}
