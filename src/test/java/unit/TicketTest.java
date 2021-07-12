package unit;

import com.mentoring.amarchuk.model.Category;
import com.mentoring.amarchuk.model.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketTest {

        Ticket ticket=new Ticket((long)999, (long)1, Category.PREMIUM,5);

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
            assertEquals(Category.PREMIUM,ticket.getCategory());
        }
}
