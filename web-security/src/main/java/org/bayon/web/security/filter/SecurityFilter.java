package org.bayon.web.security.filter;

import org.bayon.web.security.exception.AuthenticationException;
import org.bayon.web.security.exception.AuthorizationException;
import org.bayon.web.security.exception.SecurityRuntimeException;
import org.bayon.web.security.handler.AuthenticationHandler;
import org.bayon.web.security.handler.AuthorizationHandler;
import org.bayon.web.security.handler.ExcludeURIHandler;
import org.bayon.web.security.handler.LoginHandler;
import org.bayon.web.security.handler.LogoutHandler;
import org.bayon.web.security.handler.SecurityHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by nm on 14/6/17.
 */
public final class SecurityFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityFilter.class);

    private String loginPage;
    private String defaultPage;
    private String[] excludeURI;
    private SecurityHandler handler;

    @Override
    public void init(FilterConfig conf) throws ServletException {
        if (conf.getInitParameter("login-page") == null) {
            throw new SecurityRuntimeException("The 'login-page' init-param is required.");
        }
        loginPage = conf.getInitParameter("login-page");

        if (conf.getInitParameter("default-page") != null) {
            defaultPage = conf.getInitParameter("default-page");
        } else {
            defaultPage = "/";
        }

        if (conf.getInitParameter("exclude-uri") != null) {
            excludeURI = conf.getInitParameter("exclude-uri").split(",");
        }

        handler = getChainHandler();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try {
            handler.handle(request, response, chain);
        } catch (AuthenticationException e) {
            LOGGER.error(e.getMessage(), e);
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher(loginPage).forward(request, response);
        } catch (AuthorizationException e) {
            LOGGER.error(e.getMessage(), e);
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher(loginPage).forward(request, response);
        }

    }

    SecurityHandler getChainHandler() {
        LOGGER.debug("Getting security handler.");
        SecurityHandler authorizationHandler = new AuthorizationHandler();
        SecurityHandler authenticationHandler = new AuthenticationHandler(authorizationHandler);
        SecurityHandler excludeURIHandler = new ExcludeURIHandler(authenticationHandler, excludeURI);
        SecurityHandler loginHandler = new LoginHandler(excludeURIHandler, defaultPage);
        SecurityHandler looutHander = new LogoutHandler(loginHandler);
        return looutHander;
    }

    @Override
    public void destroy() {
    }
}
