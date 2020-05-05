package servlet;

import by.bsu.entity.Room;
import by.bsu.service.RoomService;
import by.bsu.util.PathUtil;
import by.bsu.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rooms")
public class ShowAllRoomsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("rooms",RoomService.getInstance().getAll());
        getServletContext()
                .getRequestDispatcher(ServletUtil.createViewPath("show-all-rooms"))
                .forward(req,resp);

    }
}
