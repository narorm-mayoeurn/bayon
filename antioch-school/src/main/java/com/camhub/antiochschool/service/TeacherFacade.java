package com.camhub.antiochschool.service;

import com.camhub.antiochschool.domain.Teacher;
import com.camhub.antiochschool.repository.SingletonRepositoryFactory;
import com.camhub.antiochschool.repository.TeacherRepository;
import com.camhub.antiochschool.repository.TeacherRepositoryImpl;
import org.bayon.ogm.datastore.query.Filter;
import org.bayon.ogm.datastore.query.Page;
import org.bayon.ogm.datastore.query.QueryBuilder;

/**
 * Created by Chandara Leang on 6/15/2017.
 */
public class TeacherFacade {
    private static final TeacherFacade INSTANCE = new TeacherFacade();

    private TeacherRepository teacherRepository;

    public static TeacherFacade getInstance() {
        return INSTANCE;
    }

    private TeacherFacade() { teacherRepository = SingletonRepositoryFactory.getFactory().getTeacherRepository(); }

    public Page<Teacher> getTeachers(int offset, int limit) {
        QueryBuilder builder = teacherRepository.createQueryBuilder();
        builder.and("archived", Filter.Operator.EQUAL, false);
        return teacherRepository.find(builder.toQuery(), offset, limit);
    }

    public Teacher get(Long id){
        return teacherRepository.findById(id);
    }

    public void delete(Long id){
        teacherRepository.remove(id);
    }

    public void update(Teacher teacher) { teacherRepository.update(teacher); }

    public Long create(Teacher teacher) { return teacherRepository.create(teacher); }
}
