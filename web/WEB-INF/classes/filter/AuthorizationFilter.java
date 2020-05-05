package filter;

import by.bsu.entity.User;
import by.bsu.entity.enums.Role;
import by.bsu.util.PathUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/admin/*")
public class AuthorizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest instanceof HttpServletRequest){
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            User currentUser = (User) httpServletRequest.getSession().getAttribute("currentUser");
            if (currentUser != null && currentUser.getRole() == Role.ADMIN){
                filterChain.doFilter(servletRequest,servletResponse);
            }
            else {
                ((HttpServletResponse) servletResponse).sendRedirect(PathUtil.LOCALHOST + "/login");
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
