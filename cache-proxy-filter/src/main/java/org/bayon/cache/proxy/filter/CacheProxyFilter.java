package org.bayon.cache.proxy.filter;

import org.bayon.cache.proxy.filter.util.CacheProxyAbility;
import org.bayon.cache.proxy.filter.util.CacheProxyConfigParameter;
import org.bayon.cache.proxy.filter.util.HttpCacheProxyHeader;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * Created by Chandara Leang on 6/13/2017.
 */

public class CacheProxyFilter implements Filter {
    private long expiration;
    private CacheProxyAbility cacheProxyAbility;
    private boolean mustRevalidate;
    private String vary;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            expiration = Long.valueOf(filterConfig.getInitParameter(CacheProxyConfigParameter.EXPIRATION.getName()));
        } catch (NumberFormatException e) {
            throw new ServletException(new StringBuilder("The initialization parameter ")
                    .append(CacheProxyConfigParameter.EXPIRATION.getName())
                    .append(" is invalid or is missing for the filter ").append(filterConfig.getFilterName())
                    .append(".").toString());
        }
        cacheProxyAbility = Boolean.valueOf(filterConfig.getInitParameter(CacheProxyConfigParameter.PRIVATE.getName())) ? CacheProxyAbility.PRIVATE : CacheProxyAbility.PUBLIC;
        mustRevalidate = Boolean.valueOf(filterConfig.getInitParameter(CacheProxyConfigParameter.MUST_REVALIDATE.getName()));
        vary = filterConfig.getInitParameter(CacheProxyConfigParameter.VARY.getName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        StringBuilder cacheControl = new StringBuilder(cacheProxyAbility.getValue()).append(", max-age=").append(expiration);
        if (mustRevalidate) {
            cacheControl.append(", must-revalidate");
        }

        httpServletResponse.setHeader(HttpCacheProxyHeader.CACHE_CONTROL.getName(), cacheControl.toString());
        httpServletResponse.setDateHeader(HttpCacheProxyHeader.EXPIRES.getName(), System.currentTimeMillis() + expiration * 1000L);

        if (vary != null && !vary.isEmpty()) {
            httpServletResponse.setHeader(HttpCacheProxyHeader.VARY.getName(), vary);
        }

        filterChain.doFilter(servletRequest, new HttpServletResponseWrapper(httpServletResponse) {
            @Override
            public void addHeader(String name, String value) {
                if (!HttpCacheProxyHeader.PRAGMA.getName().equalsIgnoreCase(name)) {
                    super.addHeader(name, value);
                }
            }

            @Override
            public void setHeader(String name, String value) {
                if (!HttpCacheProxyHeader.PRAGMA.getName().equalsIgnoreCase(name)) {
                    super.setHeader(name, value);
                }
            }
        });
    }

    @Override
    public void destroy() {
    }
}