package by.bsu.dao;

import by.bsu.connection.ConnectionManager;
import by.bsu.entity.Artist;

import javax.swing.plaf.PanelUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ArtistDao {

    private static ArtistDao INSTANCE;
    private ArtistDao () {}

    public Set<Artist> getAll() {
        Set<Artist> artists = new HashSet<>();
        try (Connection connection = ConnectionManager.newConnection()){
            String sql = "SELECT * FROM artists";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                artists.add(new Artist(resultSet.getLong("id"),
                        resultSet.getString("name")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artists;
    }

    public Artist save (Artist artist){
        try(Connection connection = ConnectionManager.newConnection()) {
            String sql = "INSERT INTO artists (name) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,artist.getName());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()){
                artist.setId(generatedKeys.getLong(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artist;
    }

    public Artist findOne(Long id){
        try(Connection connection = ConnectionManager.newConnection()) {
            String sql ="SELECT * FROM artists AS a WHERE a.id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return new Artist(resultSet.getLong("id"),resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArtistDao getInstance(){
        if (INSTANCE == null){
            synchronized (ArtistDao.class){
                if (INSTANCE == null){
                    INSTANCE = new ArtistDao();
                }
            }
        }
        return INSTANCE;
    }
}
