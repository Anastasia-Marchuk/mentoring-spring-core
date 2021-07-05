package dao;

import model.Event;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Artsiom Prokharau 02.07.2021
 */

@Repository
public class EventDao {

    private List<Event> events;

    public EventDao(List<Event> events) {
        this.events = events;
    }

    public Event getEventById(long eventId) {
        return events.stream().filter(o -> o.getId()==eventId).findAny().get();
    }

    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return events.stream().filter(o -> o.getTitle().equals(title)).collect(Collectors.toList());
    }

    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return events.stream().filter(o -> o.getDate().equals(day)).collect(Collectors.toList());
    }

    public Event createEvent(Event event) {
        events.add(event);
        return event;
    }

    public Event updateEvent(Event event) {
        events.remove(events.stream().filter(o -> o.getId()==event.getId()).collect(Collectors.toList()).get(0));
        events.add(event);
        return events.get((int) event.getId());
    }

    public boolean deleteEvent(long eventId) {
        Event event = events.get((int) eventId);
        return events.remove(event);
    }

    public int sizeEvent() {
        return events.size();
    }

}
