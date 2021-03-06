package com.camhub.antiochschool.service;

import com.camhub.antiochschool.domain.Class;
import com.camhub.antiochschool.domain.Program;
import com.camhub.antiochschool.domain.Teacher;
import com.camhub.antiochschool.repository.ClassRepository;
import com.camhub.antiochschool.repository.ProgramRepository;
import com.camhub.antiochschool.repository.SingletonRepositoryFactory;
import com.camhub.antiochschool.repository.TeacherRepository;
import org.bayon.ogm.datastore.query.Page;
import org.bayon.ogm.datastore.query.QueryBuilder;
import org.bayon.ogm.datastore.query.QueryBuilderImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nm on 16/6/17.
 */
public class ClassFacade {
    private static final ClassFacade INSTANCE = new ClassFacade();

    private ClassRepository classRepository;
    private ProgramRepository programRepository;
    private TeacherRepository teacherRepository;

    private ClassFacade() {
        classRepository = SingletonRepositoryFactory.getFactory().getClassRepository();
        programRepository = SingletonRepositoryFactory.getFactory().getProgramRepository();
        teacherRepository = SingletonRepositoryFactory.getFactory().getTeacherRepository();
    }

    public static ClassFacade getInstance() {
        return INSTANCE;
    }

    public Page<Class> getClasses(int offset, int limit) {
        return classRepository.find(offset, limit);
    }

    public Map<Long, String> getPrograms() {
        Map<Long, String> programs = new HashMap<>();
        QueryBuilder builder = programRepository.createQueryBuilder();
        builder.selectOnly("name", String.class);
        for (Program program : programRepository.find(builder.toQuery())) {
            programs.put(program.getId(), program.getName());
        }
        return programs;
    }

    public Long createClass(Class clazz) {
        return classRepository.create(clazz);
    }
    public void updateClass(Class clazz) {
        classRepository.update(clazz);
    }

    public Class get(Long id) {
        return classRepository.findById(id);
    }

    public void delete(Long id) {
        classRepository.remove(id);
    }

    public Map<Long, String> getTeachers() {
        Map<Long, String> teachers = new HashMap<>();
        QueryBuilder builder = teacherRepository.createQueryBuilder();
        builder.selectOnly("englishName", String.class);
        for (Teacher teacher : teacherRepository.find(builder.toQuery())) {
            teachers.put(teacher.getId(), teacher.getEnglishName());
        }
        return teachers;
    }

    public Map<Long, String> getAllClasses() {
        QueryBuilder builder = classRepository.createQueryBuilder();
        builder.selectOnly("name", String.class);

        Map<Long, String> classes = new HashMap<>();
        for(Class c : classRepository.find(builder.toQuery())) {
            classes.put(c.getId(), c.getName());
        }
        return classes;
    }

    public String getNameById(Long id) {
        return classRepository.findById(id).getName();
    }



    public Long createProgram(Program program) {
        return programRepository.create(program);
    }
    public void update(Program program) {
        programRepository.update(program);
    }
}
