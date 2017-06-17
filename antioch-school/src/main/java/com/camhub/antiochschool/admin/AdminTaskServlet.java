package com.camhub.antiochschool.admin;

import com.camhub.antiochschool.domain.Program;
import com.camhub.antiochschool.repository.ProgramRepository;
import com.camhub.antiochschool.repository.RepositoryFactory;
import com.camhub.antiochschool.repository.SingletonRepositoryFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nm on 16/6/17.
 */
public class AdminTaskServlet extends HttpServlet {

    private RepositoryFactory repositoryFactory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        repositoryFactory = SingletonRepositoryFactory.getFactory();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getParameter("task")) {
            case "populatePrograms": populateProgram(req); break;
        }
    }

    void populateProgram(HttpServletRequest req) {
        String[] names = req.getParameterValues("name");
        if (names == null) {
            return;
        }
        for (String name : names) {
            if (name == null || name.isEmpty()) {
                continue;
            }
            ProgramRepository repository = repositoryFactory.getProgramRepository();
            if (repository.findByName(name) == null) {
                Program program = new Program();
                program.setName(name);
                repository.create(program);
            }
        }
    }
}
