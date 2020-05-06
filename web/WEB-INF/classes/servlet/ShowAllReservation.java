package servlet;

import by.bsu.dao.ReservationDao;
import by.bsu.entity.Reservation;
import by.bsu.service.ReservationService;
import by.bsu.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/admin/reservations")
public class ShowAllReservation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<Reservation> reservations  = ReservationService.getInstance().getAll();
        System.out.println(reservations.size());
        req.setAttribute("reservations", reservations);
        getServletContext()
                .getRequestDispatcher(ServletUtil.createViewPath("show-all-reservation"))
                .forward(req,resp);
    }
}
