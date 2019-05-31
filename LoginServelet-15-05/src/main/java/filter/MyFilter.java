package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpServletRequest.getSession();
        String se = (String) session.getAttribute("loggedUser");

        if (se != null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
        }


    }

    public void destroy() {

    }
}
