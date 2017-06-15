package org.bayon.web.security.handler;

import org.bayon.web.security.exception.AuthenticationException;
import org.bayon.web.security.exception.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by nm on 15/6/17.
 */
public class ExcludeURIHandler extends SecurityHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcludeURIHandler.class);

    private String[] excludeURI;

    public ExcludeURIHandler(SecurityHandler delegate, String[] excludeURI) {
        this.delegate = delegate;
        this.excludeURI = excludeURI;
    }

    @Override
    public void handle(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, AuthenticationException, AuthorizationException {
        if (exclude(request)) {
            LOGGER.debug("Exclude URI handler.");
            chain.doFilter(request, response);
        } else {
            delegate.handle(request, response, chain);
        }
    }

    boolean exclude(ServletRequest request) {
        if (delegate == null) {
            return true;
        }
        if (excludeURI != null && excludeURI.length > 0) {
            HttpServletRequest req = (HttpServletRequest) request;
            String requestURI = req.getRequestURI();

            for (String uri : excludeURI) {
                LOGGER.debug("Exclude URI handler: " + uri);
                if (requestURI.matches(uri) || requestURI.startsWith(uri)) {
                    return true;
                }
            }
        }
        return false;
    }
}
