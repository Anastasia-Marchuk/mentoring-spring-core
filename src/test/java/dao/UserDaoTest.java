package dao;


import model.User;
import model.UserImpl;
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
@ContextConfiguration(locations = {"classpath:config.xml"})
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    List<User> users = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    @Test
    void createUser() {
        User user=new UserImpl(1,"Stacy","stacy@gmail.com");
        userDao.createUser(user);
       // assertEquals(user.getName(),userDao.getUsersByName("Stacy",1,1));
        assertEquals(1,userDao.sizeUsers());
//        Event event = new EventImpl((long) 1, "Test", new Date("12/12/2012"));
//        assertEquals(0,eventDao.sizeEvent());
//        logger.info("TEST create event "+event.getTitle());
//        eventDao.createEvent(event);
//        assertEquals(1,eventDao.sizeEvent());
    }


}