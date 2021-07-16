package com.mentoring.amarchuk.tickets.dao;

import com.mentoring.amarchuk.tickets.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class UserDaoListDBImpl implements UserDao {

    @Autowired
    private final List<User> users;

    public UserDaoListDBImpl(List<User> users) {
        this.users = users;
    }

    public User getUserById(long userId) {
        return users.stream().filter(o -> o.getId()==userId).findAny().get();
    }

    public User getUserByEmail(String email) {
        return users.stream().filter(o -> o.getEmail()==email).findAny().get();
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return users.stream().filter(o -> o.getName().equals(name)).collect(Collectors.toList());
    }

    public User createUser(User user) {
        users.add(user);
        return user;
    }

    public User updateUser(User user) {
        for (User u: users) {
            if(u.getId()==user.getId()){
                int index=users.indexOf(u);
                users.set(index,user);
                return user;
            }
        }
        return null;
    }


    public boolean deleteUser(long userId) {
        User user=users.get((int) userId);
        return users.remove(user);
    }
    public int sizeUsers() {
        return users.size();
    }
}
