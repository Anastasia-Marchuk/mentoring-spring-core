package service;



import dao.EventDao;
import model.Event;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class EventService {

    EventDao eventDao;

    public EventService(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public Event getEventById(long eventId) {
        return eventDao.getEventById(eventId);
    }

    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventDao.getEventsByTitle(title,pageSize,pageNum);
    }

    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventDao.getEventsForDay(day,pageSize,pageNum);
    }

    public Event createEvent(Event event) {
        return eventDao.createEvent(event);
    }

    public Event updateEvent(Event event) {
        return eventDao.updateEvent(event);
    }

    public boolean deleteEvent(long eventId) {
        return eventDao.deleteEvent(eventId);
    }

    public List<Event> deleteAllEvents() {
        return eventDao.deleteAllEvents();
    }
}
