package com.mentoring.amarchuk.tickets.server;

import com.mentoring.amarchuk.tickets.dao.EventDaoListDBImpl;
import com.mentoring.amarchuk.tickets.model.Event;
import com.mentoring.amarchuk.tickets.service.EventDBService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {


        @InjectMocks
        EventDBService eventService;

        @Mock
        EventDaoListDBImpl eventDao;

        @Test
        void getEventById() {
            Event event = new Event((long) 1, "Mock", new Date("25/05/2025"));

            when(eventDao.getEventById(any(Long.class))).thenReturn(event);

            Event eventById = eventService.getEventById(0);
            assertEquals(eventById, event);
        }

        @Test
        void getEventsByTitle() {
            Event event1 = new Event((long) 1, "Mock", new Date("25/05/2025"));
            Event event2 = new Event((long) 1, "Mock", new Date("25/05/2025"));
            List<Event> list = Arrays.asList(event1, event2);

            when(eventDao.getEventsByTitle(any(), any(Integer.class), any(Integer.class))).thenReturn(list);

            List<Event> mock = eventService.getEventsByTitle("Mock", 1, 1);
            assertEquals(list.size(), mock.size());
        }

        @Test
        void getEventsForDay() {
            Event event1 = new Event((long) 1, "Mock", new Date("25/05/2025"));
            Event event2 = new Event((long) 1, "Mock", new Date("25/05/2025"));
            List<Event> list = Arrays.asList(event1, event2);

            when(eventDao.getEventsForDay(any(), any(Integer.class), any(Integer.class))).thenReturn(list);

            List<Event> mock = eventService.getEventsForDay(new Date("25/05/2025"), 1, 1);
            assertEquals(list.size(), mock.size());
        }

        @Test
        void createEvent() {
            Event event = new Event((long) 1, "Mock", new Date("25/05/2025"));
            when(eventDao.createEvent(any())).thenReturn(event);
            assertEquals(eventService.createEvent(event), event);

        }

        @Test
        void updateEvent() {
            Event event = new Event((long) 1, "Mock", new Date("25/05/2025"));
            when(eventDao.updateEvent(any())).thenReturn(event);
            assertEquals(eventService.updateEvent(event), event);
        }

        @Test
        void deleteEvent() {
            when(eventDao.deleteEvent(any(Long.class))).thenReturn(true);
            Assertions.assertTrue(eventService.deleteEvent(1));
        }

//    @InjectMocks
//    EventDBService eventService;
//
//    @Mock
//    EventDao eventDao;
//
//    Event event1 = new Event((long) 1, "TestEvent", new Date("07/07/2021"));
//    Event event2 = new Event((long) 1, "TestEvent", new Date("07/07/2021"));
//
//    @Test
//    void getEventById() {
//
//        when(eventDao.getEventById(any(Long.class))).thenReturn(event1);
//        Event eventById = eventService.getEventById(0);
//        assertEquals(eventById, event1);
//    }
//
//    @Test
//    void getEventsByTitle() {
//        List<Event> list = Arrays.asList(event1, event2);
//
//        when(eventDao.getEventsByTitle(any(), any(Integer.class), any(Integer.class))).thenReturn(list);
//
//        List<Event> mock = eventService.getEventsByTitle("TestEvent", 1, 1);
//        assertEquals(list.size(), mock.size());
//    }
//
//    @Test
//    void getEventsForDay() {
//        List<Event> list = Arrays.asList(event1, event2);
//        when(eventDao.getEventsForDay(any(), any(Integer.class), any(Integer.class))).thenReturn(list);
//        List<Event> mock = eventService.getEventsForDay(new Date("07/07/2021"), 1, 1);
//        assertEquals(list.size(), mock.size());
//    }
//
//    @Test
//    void createEvent() {
//        when(eventDao.createEvent(any())).thenReturn(event1);
//        assertEquals(eventService.createEvent(event1), event1);
//
//    }
//
//    @Test
//    void updateEvent() {
//        when(eventDao.updateEvent(any())).thenReturn(event1);
//        assertEquals(eventService.updateEvent(event1), event1);
//    }
//
//    @Test
//    void deleteEvent() {
//        when(eventDao.deleteEvent(any(Long.class))).thenReturn(true);
//        assertTrue(eventService.deleteEvent(1));
//    }
}