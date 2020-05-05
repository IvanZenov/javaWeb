package by.bsu.service;

import by.bsu.dao.ReservationDao;
import by.bsu.entity.Reservation;

import java.util.Set;

public class ReservationService {
    private static ReservationService INSTANCE;

    public Reservation getRoomById(Long id){
        Reservation roomById = ReservationDao.getInstance().findById(id);
        return roomById;
    }

    public Set<Reservation> getAll(){
        Set<Reservation> reservations = ReservationDao.getInstance().findAll();
        return reservations;
    }

    public Reservation save (Reservation reservation){
        ReservationDao.getInstance().create(reservation);
        return reservation;
    }


    public static ReservationService getInstance(){
        if (INSTANCE==null){
            synchronized (ReservationService.class){
                if (INSTANCE==null){
                    INSTANCE = new ReservationService();
                }
            }
        }
        return INSTANCE;
    }
}

