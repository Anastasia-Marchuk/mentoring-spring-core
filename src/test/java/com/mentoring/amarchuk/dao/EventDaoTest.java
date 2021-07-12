package com.mentoring.amarchuk.dao;

import com.mentoring.amarchuk.model.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:configSpring.xml"})
class EventDaoTest {

    @Autowired
    private EventDaoListDBImpl eventDao;

    List<Event> list = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(EventDaoTest.class);

    @Test
    void createEvent() {
        Event event = new Event((long) 4, "Test", new Date("12/12/2012"));
        assertEquals(3,eventDao.sizeEvent());
        logger.info("TEST create event "+event.getTitle());
        eventDao.createEvent(event);
        assertEquals(4,eventDao.sizeEvent());
    }

    @Test
    void updateEvent() {
        Event eventUpdate = new Event((long)1, "UpdatedEvent", new Date("12/12/2012"));
        eventDao.updateEvent(eventUpdate);
        list.add(eventUpdate);

        logger.info("TEST update event "+eventUpdate.getId());
        List<Event> eventById = eventDao.getEventsByTitle("UpdatedEvent",1,1);
        assertEquals(list, eventById);

    }

    @Test
    void getEventById() {

        Event event = new Event((long) 100, "Test", new Date("12/12/2012"));
        eventDao.createEvent(event);
        logger.info("TEST get event by id "+event.getId());
        Assertions.assertEquals(event, eventDao.getEventById(event.getId()));
    }



    @Test
    void getEventsByTitle() {
        Event event1 = new Event((long) 1, "TestEvent", new Date("12/12/2012"));
        Event event2 = new Event((long) 2, "TestEvent", new Date("12/12/2012"));
        eventDao.createEvent(event1);
        eventDao.createEvent(event2);
        logger.info("TEST get event by title "+event1.getTitle());
        list=eventDao.getEventsByTitle("TestEvent", 1, 1);
        assertEquals(2, list.size());
    }

    @Test
    void getEventsByTitleReturnEmptyList() {

        logger.info("TEST empty list");
        assertTrue(eventDao.getEventsByTitle("Test",1,1).isEmpty());
    }

    @Test
    void getEventsForDay() {
//        System.out.println(eventDao.sizeEvent());
//        eventDao.deleteAllEvents();
        Event event = new Event((long) 1, "Test", new Date("20/07/2021"));
        eventDao.createEvent(event);
        Date date = new Date("20/07/2021");
        logger.info("TEST get event by title "+event.getDate());
        assertEquals(1, eventDao.getEventsForDay(date, 1, 1).size());
    }

    @Test
     void deleteEvent() {
        Event event = new Event((long) 10, "Event", new Date("12/12/2012"));
        eventDao.createEvent(event);

        logger.info("TEST delete all events ");
        boolean result=eventDao.deleteEvent((long)event.getId());
        assertTrue(result);
    }


}