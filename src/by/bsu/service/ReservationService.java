package by.bsu.service;

import by.bsu.dao.ReservationDao;
import by.bsu.dto.ReservationDto;
import by.bsu.entity.Reservation;

import java.util.Set;

public class ReservationService {
    private static ReservationService INSTANCE;

    public Reservation getReservationById(Long id){
        Reservation reservationById = ReservationDao.getInstance().findById(id);
        return reservationById;
    }

    public Set<Reservation> getAll(){
        Set<Reservation> reservations = ReservationDao.getInstance().findAll();
        return reservations;
    }

    public Reservation save (Reservation reservation){
        ReservationDao.getInstance().create(reservation);
        return reservation;
    }

    public Set<Reservation> getAllReservationByUserId(Long userId){
        Set<Reservation> reservations = ReservationDao.getInstance().getAllReservationByUserId(userId);
        return reservations;
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

