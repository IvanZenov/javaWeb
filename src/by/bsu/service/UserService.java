package by.bsu.service;


import by.bsu.dao.UserDao;
import by.bsu.entity.User;

import java.util.Set;

public class UserService {
    private static UserService INSTANCE;

    public User save(User user){
        User savedArtist = UserDao.getInstance().create(user);
        return savedArtist;
    }

    public User findOneById(Long id){
        User foundUser = UserDao.getInstance().findById(id);
        if (foundUser == null) {
            return null;
        }
        return foundUser;
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
