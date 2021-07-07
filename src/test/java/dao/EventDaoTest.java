package dao;

import model.Event;
import model.EventImpl;
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
@ContextConfiguration(locations = {"classpath:config.xml"})
class EventDaoTest {

    @Autowired
    private EventDao eventDao;

    List<Event> list = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(EventDaoTest.class);

    @Test
    void getEventById() {

        Event event = new EventImpl((long) 100, "Test", new Date("12/12/2012"));
        eventDao.createEvent(event);
       // Event event= (Event) eventDao.getEventsByTitle("Test",1,1);
        logger.info("TEST get event by id "+event.getId());
        assertEquals(event, eventDao.getEventById(event.getId()));
    }

    @Test
    void getEventsByTitle() {
        System.out.println(eventDao.sizeEvent());
        eventDao.deleteAllEvents();
        System.out.println(eventDao.sizeEvent());

        Event event1 = new EventImpl((long) 1, "Test", new Date("12/12/2012"));
        Event event2 = new EventImpl((long) 2, "Test", new Date("12/12/2012"));
        eventDao.createEvent(event1);
        eventDao.createEvent(event2);
        logger.info("TEST get event by title "+event1.getTitle());
        assertEquals(2, eventDao.getEventsByTitle("Test", 1, 1).size());
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
        Event event = new EventImpl((long) 1, "Test", new Date("12/12/2012"));
        eventDao.createEvent(event);
        Date date = new Date("12/12/2012");
        logger.info("TEST get event by title "+event.getDate());
        assertEquals(3, eventDao.getEventsForDay(date, 1, 1).size());
    }

    @Test
    void createEvent() {
        Event event = new EventImpl((long) 1, "Test", new Date("12/12/2012"));
        assertEquals(2,eventDao.sizeEvent());
        logger.info("TEST create event "+event.getTitle());
        eventDao.createEvent(event);
        assertEquals(3,eventDao.sizeEvent());
    }

    @Test
    void updateEvent() {

        Event event1 = new EventImpl((long) 1, "Event1", new Date("12/12/2012"));
        Event event2 = new EventImpl((long) 2 , "Event2", new Date("12/12/2012"));
        list.add(event1);
        list.add(event2);
        eventDao.createEvent(event1);
        eventDao.createEvent(event2);

        Event eventUpdate = new EventImpl((long) 1, "UpdateEvent", new Date("12/12/2012"));
        eventDao.updateEvent(eventUpdate);
        event1.setTitle("UpdateEvent");

        logger.info("TEST update event "+event1.getTitle());

        List<Event> listUpdated = new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).getTitle()=="UpdateEvent"){
                listUpdated.add(list.get(i));
            }
        }

        List<Event> eventById = eventDao.getEventsByTitle("UpdateEvent",1,1);
        assertEquals(listUpdated, eventById);

    }
    @Test
     void deleteEvent() {
        Event event = new EventImpl((long) 10, "Event", new Date("12/12/2012"));
        eventDao.createEvent(event);

        logger.info("TEST delete all events ");
        boolean result=eventDao.deleteEvent((long)event.getId());
        assertTrue(result);
    }







}