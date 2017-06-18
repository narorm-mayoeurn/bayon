package org.bayon.web.security.handler;

import org.bayon.web.security.exception.AuthenticationException;
import org.bayon.web.security.exception.AuthorizationException;
import org.bayon.web.security.manager.AuthManager;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by nm on 14/6/17.
 */
public class AuthenticationHandler extends SecurityHandler {

    public AuthenticationHandler(SecurityHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handle(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException, AuthenticationException, AuthorizationException {

        HttpServletRequest req = (HttpServletRequest)request;
        if (req.getSession() == null || req.getSession().getAttribute(AuthManager.AUTH) == null) {
            throw new AuthenticationException("Access Denied");
        }

        if (nextHandler == null) {
            chain.doFilter(request, response);
        } else {
            nextHandler.handle(request, response, chain);
        }
    }
}
