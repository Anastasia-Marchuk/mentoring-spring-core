package com.mentoring.amarchuk.tickets.facade;


import com.mentoring.amarchuk.tickets.model.Category;
import com.mentoring.amarchuk.tickets.model.Event;
import com.mentoring.amarchuk.tickets.model.Ticket;
import com.mentoring.amarchuk.tickets.model.User;
import com.mentoring.amarchuk.tickets.service.EventService;
import com.mentoring.amarchuk.tickets.service.TicketDBService;
import com.mentoring.amarchuk.tickets.service.UserService;

import java.util.Date;
import java.util.List;


public class BookingFacadeImpl implements BookingFacade {

    private EventService eventService;
    private TicketDBService ticketDBService;
    private UserService userService;

    public BookingFacadeImpl(EventService eventService, TicketDBService ticketDBService, UserService userService) {
        this.eventService = eventService;
        this.ticketDBService = ticketDBService;
        this.userService = userService;
    }

    @Override
    public Event getEventById(long eventId) {
        return eventService.getEventById(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventService.getEventsByTitle(title,pageSize,pageNum);
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventService.getEventsForDay(day, pageSize, pageNum);
    }

    @Override
    public Event createEvent(Event event) {
        return eventService.createEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventService.updateEvent(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return eventService.deleteEvent(eventId);
    }

    @Override
    public User getUserById(long userId) {
        return userService.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userService.getUsersByName(name,pageSize,pageNum);
    }

    @Override
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return userService.deleteUser(userId);
    }


    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Category category) {
        return ticketDBService.bookTicket(userId,eventId,place,category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketDBService.getBookedTickets(user,pageSize,pageNum);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketDBService.getBookedTickets(event,pageSize,pageNum);
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return ticketDBService.cancelTicket(ticketId);
    }

    public List<Event> deleteAllEvents() {
        return eventService.deleteAllEvents();
    }
}
