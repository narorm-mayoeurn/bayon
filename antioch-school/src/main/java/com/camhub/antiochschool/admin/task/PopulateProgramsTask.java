package com.camhub.antiochschool.admin.task;

import com.camhub.antiochschool.domain.Program;
import com.camhub.antiochschool.repository.ProgramRepository;
import com.camhub.antiochschool.repository.SingletonRepositoryFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nm on 17/6/17.
 */
public class PopulateProgramsTask implements Task {

    private ProgramRepository repository;

    public PopulateProgramsTask() {
        repository = SingletonRepositoryFactory.getFactory().getProgramRepository();
    }

    @Override
    public void doTask(HttpServletRequest req, HttpServletResponse res) {
        String[] names = req.getParameterValues("name");
        if (names == null) {
            return;
        }
        for (String name : names) {
            if (repository.findByName(name) == null) {
                Program program = new Program();
                program.setName(name);
                repository.create(program);
            }
        }
    }
}
