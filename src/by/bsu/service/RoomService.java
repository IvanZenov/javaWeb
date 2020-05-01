package by.bsu.service;

import by.bsu.dao.RoomDao;
import by.bsu.entity.Room;

import java.util.Set;

public class RoomService {
    private static RoomService INSTANCE;

    public Set<Room> getAll(){
        Set<Room> rooms = RoomDao.getInstance().findAll();
        return rooms;
    }
    public Room getRoomById(Long id){
        Room roomById = RoomDao.getInstance().findById(id);
        return roomById;
    }

    public Room save (Room room){
        RoomDao.getInstance().create(room);
        return room;
    }

    public static RoomService getInstance(){
        if (INSTANCE==null){
            synchronized (RoomService.class){
                if (INSTANCE==null){
                    INSTANCE = new RoomService();
                }
            }
        }
        return INSTANCE;
    }
}
