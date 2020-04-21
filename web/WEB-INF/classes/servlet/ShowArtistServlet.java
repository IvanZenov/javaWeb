package servlet;

import by.bsu.dto.ArtistDto;
import by.bsu.service.ArtistService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/artist")
public class ShowArtistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        ArtistDto foundArtist = ArtistService.getInstance().findOne(id);
        req.setAttribute("artist",foundArtist);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/classes/jsp/show-artist.jsp")
                .forward(req,resp);
    }
}
