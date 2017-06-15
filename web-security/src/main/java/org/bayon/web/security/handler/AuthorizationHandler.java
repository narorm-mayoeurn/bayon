package org.bayon.web.security.handler;

import org.bayon.web.security.exception.AuthenticationException;
import org.bayon.web.security.exception.AuthorizationException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by nm on 15/6/17.
 */
public class AuthorizationHandler extends SecurityHandler {

    @Override
    public void handle(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException, AuthenticationException, AuthorizationException {

        //TODO: Check roles implementation
        chain.doFilter(request, response);
    }
}
