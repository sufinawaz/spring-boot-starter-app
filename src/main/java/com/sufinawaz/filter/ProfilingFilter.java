package com.sufinawaz.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter
@Slf4j
public class ProfilingFilter implements Filter {

    private FilterConfig filterConfig;


    @Override
    public void init(final FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        final long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        log.info(String.format("%1$s %2$s : %3$d ms", ((HttpServletRequest) request).getMethod(), ((HttpServletRequest) request).getRequestURI(),
            (System.currentTimeMillis() - start)
        ));
    }

    @Override
    public void destroy() {

    }

    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    public void setFilterConfig(final FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
}
