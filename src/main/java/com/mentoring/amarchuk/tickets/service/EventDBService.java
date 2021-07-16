package com.mentoring.amarchuk.tickets.service;

import com.mentoring.amarchuk.tickets.dao.EventDaoListDBImpl;
import com.mentoring.amarchuk.tickets.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventDBService implements EventService {

    @Autowired
    EventDaoListDBImpl eventDaoList;

    public EventDBService(EventDaoListDBImpl eventDaoList) {
        this.eventDaoList = eventDaoList;
    }

    public Event getEventById(long eventId) {
        return eventDaoList.getEventById(eventId);
    }

    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventDaoList.getEventsByTitle(title, pageSize, pageNum);
    }

    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventDaoList.getEventsForDay(day, pageSize, pageNum);
    }

    public Event createEvent(Event event) {
        return eventDaoList.createEvent(event);
    }

    public Event updateEvent(Event event) {
        return eventDaoList.updateEvent(event);
    }

    public boolean deleteEvent(long eventId) {
        return eventDaoList.deleteEvent(eventId);
    }

    public List<Event> deleteAllEvents() {
        return eventDaoList.deleteAllEvents();
    }
}