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


@WebServlet("/room")
public class ShowRoomServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Long id = Long.valueOf(req.getParameter("id"));
            Room foundRoom = RoomService.getInstance().getRoomById(id);
            req.setAttribute("room",foundRoom);
            getServletContext()
                    .getRequestDispatcher(ServletUtil.createViewPath("show-room.jsp"))
                    .forward(req,resp);
        }
    }


