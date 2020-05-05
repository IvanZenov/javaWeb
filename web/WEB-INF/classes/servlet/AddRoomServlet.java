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

import static by.bsu.util.ServletUtil.createViewPath;

@WebServlet("/admin/addNewRoom")
public class AddRoomServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(createViewPath("add-room"))
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imageUrl = req.getParameter("imageUrl");
        String roomName = req.getParameter("name");
        String roomDescription = req.getParameter("description");
        String roomPlaces = req.getParameter("places");
        String roomPrice = req.getParameter("price");

        if (correctForm(roomName,roomPlaces,roomPrice)){
            Room savedRoom = RoomService.getInstance().save(new Room(
                    Integer.parseInt(roomPlaces),
                    Double.parseDouble(roomPrice),
                    imageUrl,
                    roomName,
                    roomDescription,
                    req.getParameter("isFree") != null
            ));
            resp.sendRedirect(PathUtil.LOCALHOST + "room?id=" + savedRoom.getId());
        }
        else {
            resp.sendRedirect(PathUtil.LOCALHOST   +"addNewRoom");
        }

    }
    public boolean correctForm(String roomName,String roomPlaces,String roomPrice){
        return !roomName.isEmpty() && !roomPlaces.isEmpty() && !roomPrice.isEmpty();
    }
}
