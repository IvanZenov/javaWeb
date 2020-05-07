package servlet;

import by.bsu.dao.UserDao;
import by.bsu.dto.UserLoginDto;
import by.bsu.entity.User;
import by.bsu.util.PathUtil;
import by.bsu.util.ServletUtil;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(ServletUtil.createViewPath("login"))
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*Gson gson = new Gson();
        UserLoginDto userDtoLogin = gson.fromJson(req.getReader().lines().collect(joining("\n")), UserLoginDto.class);
        //resp.setContentType("application/json");
        User currentUser = UserDao.validate(userDtoLogin.getEmail(),userDtoLogin.getPassword());
         */
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User currentUser = UserDao.validate(email,password);
        if (currentUser!=null){
            req.getSession().setAttribute("currentUser", currentUser);
            resp.sendRedirect(PathUtil.LOCALHOST + "/rooms");
        }
        else {
            resp.sendRedirect(PathUtil.LOCALHOST + "/login");
        }

    }

}
