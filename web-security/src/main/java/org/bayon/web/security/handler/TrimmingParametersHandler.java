package org.bayon.web.security.handler;

import org.bayon.web.security.exception.AuthenticationException;
import org.bayon.web.security.exception.AuthorizationException;
import org.bayon.web.security.http.TrimmingParametersHttpServletRequest;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by nm on 18/6/17.
 */
public class TrimmingParametersHandler extends SecurityHandler {

    public TrimmingParametersHandler(SecurityHandler handler) {
        nextHandler = handler;
    }

    @Override
    public void handle(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, AuthenticationException, AuthorizationException {
        request = new TrimmingParametersHttpServletRequest((HttpServletRequest) request);

        if (nextHandler == null) {
            chain.doFilter(request, response);
        } else {
            nextHandler.handle(request, response, chain);
        }
    }
}
