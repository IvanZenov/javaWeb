package servlet;

import by.bsu.entity.User;
import by.bsu.entity.enums.Role;
import by.bsu.service.UserService;
import by.bsu.util.PathUtil;
import by.bsu.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.bsu.util.ServletUtil.createViewPath;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(createViewPath("registration"))
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phoneNumber = req.getParameter("phoneNumber");

        UserService.getInstance().save(new User(
                firstName,
                secondName,
                email,
                password,
                phoneNumber
        ));
        resp.sendRedirect(PathUtil.LOCALHOST + "/users");

    }
}
