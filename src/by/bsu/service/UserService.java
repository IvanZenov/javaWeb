package by.bsu.service;


import by.bsu.dao.UserDao;
import by.bsu.dto.UserDto;
import by.bsu.entity.User;

import java.util.Set;

public class UserService {
    private static UserService INSTANCE;

    public UserDto save(User user){
        User savedArtist = UserDao.getInstance().create(user);
        return new UserDto(savedArtist.getId(),savedArtist.getFirstName(), savedArtist.getEmail());
    }

    public UserDto findOneById(Long id){
        User foundUser = UserDao.getInstance().findById(id);
        if (foundUser == null) {
            return null;
        }
        return new UserDto(foundUser.getId(),foundUser.getFirstName(),foundUser.getEmail());
    }

    public Set<User> findAll (){
        Set<User> users = UserDao.getInstance().findAll();
        return users;
    }

    public static UserService getInstance() {
        if (INSTANCE == null) {
            synchronized (UserService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserService();
                }
            }
        }
        return INSTANCE;
    }

}
