package org.bayon.web.security.manager;

import org.bayon.web.security.domain.User;
import org.bayon.web.security.exception.AuthenticationException;
import org.bayon.web.security.repository.UserRepository;
import org.bayon.web.security.repository.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nm on 14/6/17.
 */
public class AuthManager {

    private static final AuthManager INSTANCE = new AuthManager();

    public static final String AUTH = "auth";
    public static final String ADMIN = "admin";

    private UserRepository userRepository;

    public static AuthManager getInstance() {
        return INSTANCE;
    }

    private AuthManager() {
        userRepository = new UserRepositoryImpl();
        if (userRepository.findByUsername("admin") == null) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("admin");
            List<String> roles = new ArrayList<>();
            roles.add(User.ADMIN);
            roles.add(User.USER);
            admin.setRoles(roles);
            userRepository.create(admin);
        }
    }

    public User authenticate(String username, String password) throws AuthenticationException {
        User auth = userRepository.findByUsername(username);
        if (auth == null || !auth.getPassword().equals(password)) {
            throw new AuthenticationException("Username or password incorrect.");
        }
        return auth;
    }
}
