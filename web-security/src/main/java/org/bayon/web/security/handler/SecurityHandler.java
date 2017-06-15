package org.bayon.web.security.handler;

import org.bayon.web.security.exception.AuthenticationException;
import org.bayon.web.security.exception.AuthorizationException;
import org.bayon.web.security.manager.AuthManager;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by nm on 14/6/17.
 */
public abstract class SecurityHandler {

    public static final String INDEX = "/";
    public static final String LOGIN = "/login";
    public static final String LOGOUT = "/logout";

    protected AuthManager authManager = AuthManager.getInstance();
    protected SecurityHandler nextHandler;

    public abstract void handle(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException, AuthenticationException, AuthorizationException;
}
