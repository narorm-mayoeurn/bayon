package com.camhub.antiochschool.admin.task;

import com.camhub.antiochschool.repository.SingletonRepositoryFactory;
import org.bayon.web.security.domain.User;
import org.bayon.web.security.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by nm on 17/6/17.
 */
public class CreateAdminUserTask implements Task {

    private UserRepository repository;

    public CreateAdminUserTask() {
        repository = SingletonRepositoryFactory.getFactory().getUserRepository();
    }

    @Override
    public void doTask(HttpServletRequest req, HttpServletResponse res) {
        String username = req.getParameter("username");
        if (repository.findByUsername(username) == null) {
            User user = new User();

            user.setName(req.getParameter("name"));
            user.setUsername(username);
            user.setPassword(req.getParameter("password"));
            List<String> roles = new ArrayList<>();
            for (String role : req.getParameterValues("roles")) {
                roles.add(role.toUpperCase());
            }
            user.setRoles(roles);
            repository.create(user);
        }
    }
}
