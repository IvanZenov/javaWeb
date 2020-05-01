package by.bsu.dao;

import by.bsu.connection.ConnectionManager;
import by.bsu.entity.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class RoomDao implements GenericDao<Room>{
    private static RoomDao INSTANCE;
    private RoomDao() {
    }

    /*
    public Set<Room> getAllFreeRooms() {
        Set<Room> rooms = new HashSet<>();
        try(Connection connection = ConnectionManager.newConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM room WHERE is_free = true");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                rooms.add(new Room(resultSet.getLong("id"),
                        resultSet.getInt("places"),
                        resultSet.getDouble("price_per_night"),
                        resultSet.getString("image_url"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getBoolean("is_free")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }
    public Set<Room> getRoomsWithGivenPrice (double from, double to){
        Set<Room> rooms = new HashSet<>();
        try(Connection connection = ConnectionManager.newConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM rooms WHERE price_per_night >= (?) AND price_per_night <= (?)");
            preparedStatement.setDouble(1, from);
            preparedStatement.setDouble(2,to);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                rooms.add(new Room(resultSet.getLong("id"),
                        resultSet.getInt("places"),
                        resultSet.getDouble("price_per_night"),
                        resultSet.getString("image_url"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getBoolean("is_free")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

     */

    public static RoomDao getInstance() {
        if (INSTANCE == null) {
            synchronized (RoomDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RoomDao();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Room create(Room entity) {
        try(Connection connection = ConnectionManager.newConnection()) {
            String sql = "INSERT INTO room(image_url, name, description, places, price_per_night, is_free) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,entity.getImageUrl());
            preparedStatement.setString(2,entity.getName());
            preparedStatement.setString(3,entity.getDescription());
            preparedStatement.setInt(4,entity.getPlaces());
            preparedStatement.setDouble(5,entity.getDailyPrice());
            preparedStatement.setBoolean(6,entity.isFree());
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
        String sql = "DELETE room where id = ?";
        try(Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Room findById(Long id) {
        try(Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM room WHERE id = ?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return new Room(
                        resultSet.getLong("id"),
                        resultSet.getInt("places"),
                        resultSet.getDouble("price_per_night"),
                        resultSet.getString("image_url"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getBoolean("is_free")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<Room> findAll() {
        Set<Room> rooms = new HashSet<>();
        try(Connection connection = ConnectionManager.newConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM room");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                rooms.add(new Room(resultSet.getLong("id"),
                        resultSet.getInt("places"),
                        resultSet.getDouble("price_per_night"),
                        resultSet.getString("image_url"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getBoolean("is_free")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public void updateRoom (Long id, String imageUrl, String name,
                            String description, int places, double price, boolean isFree) {
        String sql = "UPDATE room set image_url = ?,name = ?, description = ?, places = ?, price_per_night = ?, is_free = ? WHERE id = ?";
        try(Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,imageUrl);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,description);
            preparedStatement.setInt(4,places);
            preparedStatement.setDouble(5,price);
            preparedStatement.setBoolean(6,isFree);
            preparedStatement.setLong(7,id);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //TODO: write this method. Problem: how to get List of places (1,2 and etc.).
    public Set<Room> getRoomsWithCriteria (int places, double priceFrom, double priceTo, String name, boolean is_free){
        return null;
    }

}
