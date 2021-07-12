package com.mentoring.amarchuk.service;

import com.mentoring.amarchuk.dao.TicketDao;
import com.mentoring.amarchuk.dao.TicketDaoListDBImpl;
import com.mentoring.amarchuk.model.Category;
import com.mentoring.amarchuk.model.Event;
import com.mentoring.amarchuk.model.Ticket;
import com.mentoring.amarchuk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketDBService implements TicketService{

    @Autowired
    TicketDaoListDBImpl ticketDaoListDB;

    public TicketDBService(TicketDaoListDBImpl ticketDaoListDB) {
        this.ticketDaoListDB = ticketDaoListDB;
    }

    public Ticket bookTicket(long userId, long eventId, int place, Category category) {
        return ticketDaoListDB.bookTicket(userId,eventId,place,category);
    }

    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketDaoListDB.getBookedTickets(user,pageSize,pageNum);
    }

    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketDaoListDB.getBookedTickets(event,pageSize,pageNum);
    }

    public boolean cancelTicket(long ticketId) {
        return ticketDaoListDB.cancelTicket(ticketId);
    }
}
