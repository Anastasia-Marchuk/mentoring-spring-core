package com.mentoring.amarchuk.dao;

import com.mentoring.amarchuk.model.Category;
import com.mentoring.amarchuk.model.Event;
import com.mentoring.amarchuk.model.Ticket;
import com.mentoring.amarchuk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository

public class TicketDaoListDBImpl implements TicketDao{

        @Autowired
        private Map<String, Ticket> tickets;

//    public TicketDaoListDBImpl(Map<String, Ticket> tickets) {
//        this.tickets = tickets;
//    }

    public void setTickets(Map<String, Ticket> tickets) {
        this.tickets = tickets;
    }

    public Ticket bookTicket(long userId, long eventId, int place, Category category) {
            Ticket ticket = new Ticket(eventId, userId, category, place);
            long newId=tickets.size()+1;
            ticket.setId(newId);
            tickets.put("ticket" + ticket.getId(), ticket);
            return ticket;
        }

        public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
            long id = user.getId();
            return tickets.values().stream().filter(o -> o.getUserId() == id).collect(Collectors.toList());
        }

        public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
            long id=event.getId();
            return tickets.values().stream().filter(o -> o.getEventId() == id).collect(Collectors.toList());
        }

        public boolean cancelTicket(long ticketId) {
            return tickets.keySet().removeIf(key -> key.equals("ticket" +ticketId));
        }
    }