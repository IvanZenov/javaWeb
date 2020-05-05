package filter;


import by.bsu.util.PathUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Path;

@WebFilter(urlPatterns = {"/rooms","/users","/addNewRoom","/saveData","/room"})
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest instanceof  HttpServletRequest){
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

            if (httpServletRequest.getSession().getAttribute("currentUser") != null){
                filterChain.doFilter(servletRequest,servletResponse);
            }
            else {
                ((HttpServletResponse) servletResponse).sendRedirect(PathUtil.LOCALHOST+ "/login");
            }
        }
        else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
