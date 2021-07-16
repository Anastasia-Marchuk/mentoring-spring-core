package com.mentoring.amarchuk.tickets.dao;

import com.mentoring.amarchuk.tickets.model.Category;
import com.mentoring.amarchuk.tickets.model.Event;
import com.mentoring.amarchuk.tickets.model.Ticket;
import com.mentoring.amarchuk.tickets.model.User;

import java.util.List;


public interface TicketDao {

    Ticket bookTicket(long userId, long eventId, int place, Category category);

    List<Ticket> getBookedTickets(User user, int pageSize, int pageNum);

    List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum);

    boolean cancelTicket(long ticketId);
}
