package by.bsu.dao;

import by.bsu.connection.ConnectionManager;
import by.bsu.entity.Reservation;
import by.bsu.entity.enums.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ReservationDao implements GenericDao<Reservation>{
    private static ReservationDao INSTANCE;
    private ReservationDao(){}


    @Override
    public Reservation create(Reservation entity) {
        try(Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO reservation (user_id,room_id,arrival,checkout,status) VALUES (?,?,?,?,?)");
            preparedStatement.setLong(1, entity.getUserId());
            preparedStatement.setLong(2, entity.getRoomId());
            preparedStatement.setDate(3, entity.getArrival());
            preparedStatement.setDate(4, entity.getCheckout());
            preparedStatement.setString(5, entity.getStatus().toString());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()){
                entity.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public void delete(Long id) {
        try(Connection connection = ConnectionManager.newConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE reservation WHERE id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Reservation findById(Long id) {
        try(Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM reservation WHERE id = ?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return new Reservation(
                        resultSet.getLong("id"),
                        resultSet.getLong("user_id"),
                        resultSet.getLong("room_id"),
                        resultSet.getDate("arrival"),
                        resultSet.getDate("checkout"),
                        Status.valueOf(resultSet.getString("status")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<Reservation> findAll() {
        Set<Reservation> reservations = new HashSet<>();
        try(Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from reservation;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                reservations.add(new Reservation(
                        resultSet.getLong("id"),
                        resultSet.getLong("user_id"),
                        resultSet.getLong("room_id"),
                        resultSet.getDate("arrival"),
                        resultSet.getDate("checkout"),
                        Status.valueOf(resultSet.getString("status"))));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    public Set<Reservation> getAllReservationByUserId (Long userId){
        Set<Reservation> reservations = new HashSet<>();
        try(Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM reservation AS r JOIN users as u ON r.user_id = u.id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                reservations.add(new Reservation(
                        resultSet.getLong("id"),
                        resultSet.getLong("user_id"),
                        resultSet.getLong("room_id"),
                        resultSet.getDate("arrival"),
                        resultSet.getDate("checkout"),
                        Status.valueOf(resultSet.getString("status"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    public static ReservationDao getInstance(){
        if (INSTANCE == null){
            synchronized (ReservationDao.class){
                if (INSTANCE == null){
                    INSTANCE = new ReservationDao();
                }
            }
        }
        return INSTANCE;
    }

}
