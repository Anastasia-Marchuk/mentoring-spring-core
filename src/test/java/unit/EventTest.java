package unit;

import model.Event;
import model.EventImpl;
import model.User;
import model.UserImpl;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    Date date=new Date();
   Event event=new EventImpl((long) 959595,"Title",date);

    @Test
    public void testGetTitle(){
        assertEquals("Title",event.getTitle());
    }

    @Test
    public void testGetIdEvent(){
        assertEquals(959595,event.getId());
    }

    @Test
    public void testGetDateEvent(){
        assertEquals(date,event.getDate());
    }
}
