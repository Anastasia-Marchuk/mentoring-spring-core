package unit;

import model.Event;
import model.EventImpl;
import model.Ticket;
import model.TicketImpl;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketTest {

        Ticket ticket=new TicketImpl((long)999, (long)1, Ticket.Category.PREMIUM,5);

        @Test
        public void testGetEventId(){
            assertEquals(999,ticket.getEventId());
        }

        @Test
        public void testGetUserId(){
            assertEquals(1,ticket.getUserId());
        }

        @Test
        public void testGetPlaceId(){
            assertEquals(5,ticket.getPlace());
        }

        @Test
        public void testGetCategory(){
            assertEquals(Ticket.Category.PREMIUM,ticket.getCategory());
        }
}
