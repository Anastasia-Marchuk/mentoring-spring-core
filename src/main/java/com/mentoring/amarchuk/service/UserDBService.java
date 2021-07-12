package com.mentoring.amarchuk.service;

import com.mentoring.amarchuk.dao.UserDaoListDBImpl;
import com.mentoring.amarchuk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDBService implements UserService {

    @Autowired
    UserDaoListDBImpl userDaoListDBImpl;

    public UserDBService(UserDaoListDBImpl userDaoListDBImpl) {
        this.userDaoListDBImpl = userDaoListDBImpl;
    }

    public User getUserById(long userId) {
        return userDaoListDBImpl.getUserById(userId);
    }

    public User getUserByEmail(String email) {
        return userDaoListDBImpl.getUserByEmail(email);
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userDaoListDBImpl.getUsersByName(name,pageSize,pageNum);
    }

    public User createUser(User user) {
        return userDaoListDBImpl.createUser(user);
    }

    public User updateUser(User user) {
        return userDaoListDBImpl.updateUser(user);
    }

    public boolean deleteUser(long userId) {
         return userDaoListDBImpl.deleteUser(userId);
    }
}
