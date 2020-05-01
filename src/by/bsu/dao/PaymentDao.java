package by.bsu.dao;

import by.bsu.connection.ConnectionManager;
import by.bsu.entity.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class PaymentDao implements GenericDao<Payment>{
    private PaymentDao(){}
    private static PaymentDao INSTANCE;


    private PaymentDao getInstance(){
        if (INSTANCE == null){
            synchronized (PaymentDao.class){
                INSTANCE = new PaymentDao();
            }
        }
        return INSTANCE;
    }

    @Override
    public Payment create(Payment entity) {
        try(Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO payment (user_id,reservation_id,money,description) VALUES (?,?,?,?)");
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

    }

    @Override
    public Payment findById(Long id) {
        try(Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM payment where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return new Payment(
                    resultSet.getLong("id"),
                    resultSet.getLong("user_id"),
                    resultSet.getLong("reservation_id"),
                    resultSet.getDouble("money"),
                    resultSet.getString("description")
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<Payment> findAll() {
        Set<Payment> payments = new HashSet<>();
        try(Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM payment");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                payments.add(new Payment(
                        resultSet.getLong("id"),
                        resultSet.getLong("user_id"),
                        resultSet.getLong("reservation_id"),
                        resultSet.getDouble("money"),
                        resultSet.getString("description")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }
}
