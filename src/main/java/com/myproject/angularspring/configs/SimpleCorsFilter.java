package com.myproject.angularspring.configs;

import java.io.IOException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCorsFilter implements Filter {


    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        String originHeader = request.getHeader("origin");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, originHeader);
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "3600");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "*");

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }

}