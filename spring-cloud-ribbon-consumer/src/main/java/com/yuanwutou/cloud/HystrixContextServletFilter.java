package com.yuanwutou.cloud;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "hystrixContextServletFilter",urlPatterns = "/*",asyncSupported = true)
public class HystrixContextServletFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HystrixRequestContext context=HystrixRequestContext.initializeContext();
        try {
            filterChain.doFilter(servletRequest,servletResponse);
        }finally {
            context.shutdown();
        }
    }

    @Override
    public void destroy() {

    }
}
