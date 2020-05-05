package by.bsu.dao;

import by.bsu.connection.ConnectionManager;
import by.bsu.entity.User;
import by.bsu.entity.enums.Role;
import by.bsu.entity.enums.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDao implements GenericDao<User>{
    private static UserDao INSTANCE;
    private UserDao () {}

    public static UserDao getInstance(){
        if (INSTANCE == null){
            synchronized (UserDao.class){
                if (INSTANCE == null){
                    INSTANCE = new UserDao();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public User create(User entity) {
        try(Connection connection = ConnectionManager.newConnection()) {
            String sql = "INSERT INTO users (first_name, second_name, email, password, phone_number, role, money) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,entity.getFirstName());
            preparedStatement.setString(2,entity.getSecondName());
            preparedStatement.setString(3,entity.getEmail());
            preparedStatement.setString(4,entity.getPassword());
            preparedStatement.setString(5,entity.getPhoneNumber());
            preparedStatement.setString(6,entity.getRole().toString());
            preparedStatement.setDouble(7,entity.getMoney());

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
        try(Connection connection = ConnectionManager.newConnection()) {
            String sql = "DELETE users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);
            //TODO: check Update or Execute?
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public User findById(Long id) {
        try(Connection connection = ConnectionManager.newConnection()) {
            String sql ="SELECT * FROM users AS a WHERE a.id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                //TODO: change Role.USER to resultSet.getString -> and get string ADMIN/USER
                return new User(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("second_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        Role.valueOf(resultSet.getString("role")),
                        resultSet.getString("phone_number"),
                        resultSet.getDouble("money")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();
        try(Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                users.add(new User(resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("second_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        Role.USER,
                        resultSet.getString("phone_number"),
                        resultSet.getDouble("money")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static User validate(String email, String password){
        try(Connection connection = ConnectionManager.newConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return new User(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("second_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        Role.valueOf(resultSet.getString("role")),
                        resultSet.getString("phone_number"),
                        resultSet.getDouble("money")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deposit (Long id, double amount){
        try(Connection connection = ConnectionManager.newConnection()) {
            String sql = "UPDATE user set money = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1,amount);
            preparedStatement.setLong(2,id);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
