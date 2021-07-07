package service;


import dao.UserDao;
import model.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserById(long userId) {
        return userDao.getUserById(userId);
    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userDao.getUsersByName(name,pageSize,pageNum);
    }

    public User createUser(User user) {
        return userDao.createUser(user);
    }

    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    public boolean deleteUser(long userId) {
         return userDao.deleteUser(userId);
    }
}
