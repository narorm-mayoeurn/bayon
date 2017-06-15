package org.bayon.web.security.handler;

import org.bayon.web.security.exception.AuthenticationException;
import org.bayon.web.security.exception.AuthorizationException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nm on 15/6/17.
 */
public class LogoutHandler extends SecurityHandler {

    public LogoutHandler(SecurityHandler delegate) {
        this.delegate = delegate;
    }

    @Override
    public void handle(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, AuthenticationException, AuthorizationException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getRequestURI().startsWith(LOGOUT)) {
            req.getSession().invalidate();
            ((HttpServletResponse) response).sendRedirect(INDEX);
        }
        if (delegate == null) {
            chain.doFilter(request, response);
        } else {
            delegate.handle(request, response, chain);
        }
    }
}
