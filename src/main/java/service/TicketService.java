package service;



import dao.TicketDao;
import model.Event;
import model.Ticket;
import model.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketService {

    TicketDao ticketDao;

    public TicketService(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return ticketDao.bookTicket(userId,eventId,place,category);
    }

    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketDao.getBookedTickets(user,pageSize,pageNum);
    }

    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketDao.getBookedTickets(event,pageSize,pageNum);
    }

    public boolean cancelTicket(long ticketId) {
        return ticketDao.cancelTicket(ticketId);
    }
}
