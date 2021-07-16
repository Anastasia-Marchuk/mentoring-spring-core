package com.mentoring.amarchuk.tickets.service;

import com.mentoring.amarchuk.tickets.dao.UserDaoListDBImpl;
import com.mentoring.amarchuk.tickets.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDBService implements UserService {

    @Autowired
    UserDaoListDBImpl userDaoListDBImpl;

    // do all cheks

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

    public User updateUser(User user) throws NullPointerException {
        User userUpdated=userDaoListDBImpl.updateUser(user);
        if(userUpdated==null){
            throw new NullPointerException("Error updating user "+user);
        }
        return userUpdated;
    }

    public boolean deleteUser(long userId) {
         return userDaoListDBImpl.deleteUser(userId);
    }
}
