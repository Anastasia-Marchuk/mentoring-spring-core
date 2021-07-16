package com.mentoring.amarchuk.tickets.dao;


import com.mentoring.amarchuk.tickets.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:configSpring.xml"})
class UserDaoListDBImplTest {

    //delete autowired
    @Autowired
    private UserDaoListDBImpl userDao;

    List<User> list = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(UserDaoListDBImplTest.class);

    @Test
    void createUser() {
        User user=new User(1,"newStacy","new_stacy@gmail.com");
        userDao.createUser(user);
        assertEquals(5, userDao.sizeUsers());

    }


}