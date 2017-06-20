package com.camhub.antiochschool.admin.task;

import com.camhub.antiochschool.domain.Class;
import com.camhub.antiochschool.domain.Program;
import com.camhub.antiochschool.domain.Student;
import com.camhub.antiochschool.domain.Teacher;
import com.camhub.antiochschool.repository.RepositoryFactory;
import com.camhub.antiochschool.repository.SingletonRepositoryFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by nm on 18/6/17.
 */
public class PopulateMockDataTask implements Task {

    private RepositoryFactory factory;

    public PopulateMockDataTask() {
        factory = SingletonRepositoryFactory.getFactory();
    }

    @Override
    public void doTask(HttpServletRequest req, HttpServletResponse res) {

        int number = 10;
        if (req.getParameter("number") != null) {
            number = Integer.parseInt(req.getParameter("number"));
        }

        Random rand = new Random();

        for (int i = 0; i < number; i++) {
            Program program = new Program();
            program.setName("Program " + i);
            program.setId(factory.getProgramRepository().create(program));

            Teacher teacher = new Teacher();
            teacher.setKhmerName("Khmer Name " + i);
            teacher.setEnglishName("English Name " + i);
            teacher.setBirthdate(Calendar.getInstance().getTime());
            teacher.setGender("M");
            teacher.setEmail("teacher" + i + "@email.com");
            teacher.setPhone(String.valueOf(rand.nextInt()));
            teacher.setId(factory.getTeacherRepository().create(teacher));

            Class clazz = new Class();
            clazz.setName("Class " + i);
            clazz.setSession("Morning");
            clazz.setDescription("Description " + i);
            clazz.setProgramId(program.getId());
            clazz.setTeacherId(teacher.getId());
            clazz.setId(factory.getClassRepository().create(clazz));

            Student student = new Student();
            student.setKhmerName("Khmer Student Name " + i);
            student.setEnglishName("English Student Name " + i);
            student.setGender("M");
            student.setBirthDate(Calendar.getInstance().getTime());
            student.setRegisteredDate(Calendar.getInstance().getTime());
            student.setContactAddress("Contact Address " + i);
            student.setContactPhone("Contact Phone " + i);
            student.setStudentId("SID" + i);
            student.setClassId(clazz.getId());
            student.setId(factory.getStudentRepository().create(student));
        }

    }
}
