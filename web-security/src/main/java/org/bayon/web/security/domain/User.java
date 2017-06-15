package org.bayon.web.security.domain;

import java.util.List;

/**
 * Created by nm on 14/6/17.
 */
public class User {

    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";

    private Long id;
    private String username;
    private String password;
    private List<String> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
