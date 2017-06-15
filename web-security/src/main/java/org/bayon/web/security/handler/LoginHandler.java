package org.bayon.web.security.handler;

import org.bayon.web.security.domain.User;
import org.bayon.web.security.exception.AuthenticationException;
import org.bayon.web.security.exception.AuthorizationException;
import org.bayon.web.security.manager.AuthManager;

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
public class LoginHandler extends SecurityHandler {

    private String defaultPage;

    public LoginHandler(SecurityHandler delegate, String defaultPage) {
        this.delegate = delegate;
        this.defaultPage = defaultPage;
    }

    @Override
    public void handle(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, AuthenticationException, AuthorizationException {
        HttpServletRequest req = (HttpServletRequest) request;
        if ("post".equalsIgnoreCase(req.getMethod()) && req.getRequestURI().startsWith(LOGIN)) {

            String username = req.getParameter("username");
            String password = req.getParameter("password");
            User user = authManager.authenticate(username, password);

            req.getSession().setAttribute(AuthManager.AUTH, true);
            req.getSession().setAttribute(AuthManager.ADMIN, user.getRoles().contains(User.ADMIN));

            ((HttpServletResponse) response).sendRedirect(defaultPage);
        }

        if (delegate == null) {
            chain.doFilter(request, response);
        } else {
            delegate.handle(request, response, chain);
        }
    }
}
