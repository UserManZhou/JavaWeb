package com.gec.web.filter;

import com.gec.web.utils.PathUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class InitFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化-----------------------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String path = PathUtil.getPath(request.getRequestURI());
        if (path.equals("login") || path.equals("register") || path.equals("register_user") || path.equals("updateImg") || path.equals("loginUser") || path.equals("signOut")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else if (session.getAttribute("username") == null){
            System.out.println("Kong");
//            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
//            response.setHeader("Location",request.getServletContext().getContextPath()+"/login");
            request.getRequestDispatcher("/login").forward(request,response);
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            System.out.println(username.toString());
            filterChain.doFilter(servletRequest,servletResponse);
        }



    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁完毕-------------------");
    }
}
