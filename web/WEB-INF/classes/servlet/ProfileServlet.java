package servlet;

import by.bsu.entity.Reservation;
import by.bsu.entity.User;
import by.bsu.service.ReservationService;
import by.bsu.service.RoomService;
import by.bsu.service.UserService;
import by.bsu.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User)req.getSession().getAttribute("currentUser");
        Set<Reservation> allReservationByUserId = ReservationService.getInstance().getAllReservationByUserId(currentUser.getId());
        System.out.println(allReservationByUserId.size());
        req.setAttribute("currentUserReservation", allReservationByUserId);
        getServletContext()
                .getRequestDispatcher(ServletUtil.createViewPath("profile"))
                .forward(req,resp);
    }

    //TODO: Make this doPost Method!!!
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reservationId = req.getParameter("id");
        User currentUser = (User) req.getSession().getAttribute("currentUser");

        if (!reservationId.isEmpty() && currentUser != null){

        }
    }
}
