package servlet;

import by.bsu.dao.ReservationDao;
import by.bsu.dto.ReservationDto;
import by.bsu.entity.Reservation;
import by.bsu.service.ReservationService;
import by.bsu.util.ServletUtil;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

import static java.util.stream.Collectors.joining;

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        ReservationDto userDtoLogin = gson.fromJson(req.getReader().lines().collect(joining("\n")), ReservationDto.class);
        System.out.println(userDtoLogin.getReservationId() + " " + userDtoLogin.getStatus());
        Reservation reservationById = ReservationService.getInstance().getReservationById(Long.valueOf(userDtoLogin.getReservationId()));
        reservationById.setStatus(userDtoLogin.getStatus());
    }
}
