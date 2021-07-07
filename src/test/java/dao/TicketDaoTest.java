package dao;

import model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:config.xml"})
public class TicketDaoTest {

    @Autowired
    private TicketDao ticketDao;

    private Map<String, Ticket> tickets;

    private static Logger logger = LoggerFactory.getLogger(EventDaoTest.class);

//    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
//        TicketImpl ticket = new TicketImpl(eventId, userId, category, place);
//        long newId=tickets.size()+1;
//        ticket.setId(newId);
//        tickets.put("ticket" + ticket.getId(), ticket);
//        return ticket;
//    }

    @Test
    void testBookTicket() {
        TicketImpl ticket = new TicketImpl((long)1, (long)1, Ticket.Category.PREMIUM, 8);
        User user=new UserImpl(1,"Stacy","email");
        long newId=tickets.size()+1;
        ticket.setId(newId);
        tickets.put("ticket" + ticket.getId(), ticket);
        assertEquals(1,ticketDao.getBookedTickets(user,1,1));


    }
}
