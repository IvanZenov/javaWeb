package servlet;

import by.bsu.entity.Reservation;
import by.bsu.entity.Room;
import by.bsu.entity.User;
import by.bsu.entity.enums.Status;
import by.bsu.service.ReservationService;
import by.bsu.service.RoomService;
import by.bsu.util.PathUtil;
import by.bsu.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;


@WebServlet("/reserve")
public class ReserveRoomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long room_id = Long.valueOf(req.getParameter("id"));
        Room currentRoom =  RoomService.getInstance().getRoomById(room_id);
        req.getSession().setAttribute("currentRoom", currentRoom);
        getServletContext()
                .getRequestDispatcher(ServletUtil.createViewPath("reservation"))
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String arrival = req.getParameter("arrival");
        String checkout = req.getParameter("checkout");
        Room currentRoom = (Room) req.getSession().getAttribute("currentRoom");
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        if (correctData(arrival,checkout)){
            ReservationService.getInstance().save(
                    new Reservation(
                            currentUser.getId(),
                            currentRoom.getId(),
                            Date.valueOf(arrival),
                            Date.valueOf(checkout)
                    )
            );
            resp.sendRedirect(PathUtil.LOCALHOST + "/profile");
        }
        else {
            resp.sendRedirect(PathUtil.LOCALHOST + "/reserve" + currentRoom.getId().toString());
        }

    }

    private boolean correctData (String arrival, String checkout){
        return arrival.isEmpty()&&checkout.isEmpty();
    }

}

