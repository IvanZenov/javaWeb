package servlet;

import by.bsu.dto.ArtistDto;
import by.bsu.entity.Artist;
import by.bsu.service.ArtistService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.MidiFileFormat;
import java.io.IOException;

@WebServlet("/saveArtist")
public class SaveArtistServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/WEB-INF/classes/jsp/save-artist.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String artistName = req.getParameter("name");
        if (!artistName.isEmpty()){
            ArtistDto savedArtist = ArtistService.getInstance().save(new Artist(artistName));
            resp.sendRedirect("/javaEE_war_exploded/artist?id=" + savedArtist.getId());
        }
        else {
            resp.sendRedirect("/javaEE_war_exploded/saveArtist");
        }

    }
}
