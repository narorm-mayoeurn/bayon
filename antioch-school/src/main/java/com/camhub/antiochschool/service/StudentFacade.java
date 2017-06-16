package com.camhub.antiochschool.service;

import com.camhub.antiochschool.domain.Student;
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

    public static StudentFacade getInstance() {
        return INSTANCE;
    }

    private StudentFacade() {
        studentRepository = SingletonRepositoryFactory.getFactory().getStudentRepository();
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
}
