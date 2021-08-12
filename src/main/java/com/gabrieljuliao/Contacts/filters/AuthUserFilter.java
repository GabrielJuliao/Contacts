package com.gabrieljuliao.Contacts.filters;

import com.gabrieljuliao.Contacts.StaticContent;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthUserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String URI = request.getContextPath();
        
        boolean isSignIn = request.getRequestURI().equals(URI+"/SignIn");
        boolean isSignUp = request.getRequestURI().equals(URI+"/SignUp");
        boolean isSignedIn = session != null && session.getAttribute("user") != null;
        boolean isStatic = isStaticContent(request.getRequestURI());

        if (isSignIn || isSignUp || isStatic || isSignedIn) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(URI+"/SignIn");
        }
        
    }

    protected boolean isStaticContent(String uri) {
        for (StaticContent contentType : StaticContent.values()) {
            if (uri.endsWith("."+ contentType)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
