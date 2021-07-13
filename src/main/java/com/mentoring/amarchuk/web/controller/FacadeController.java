package com.mentoring.amarchuk.web.controller;

import com.mentoring.amarchuk.model.Category;
import com.mentoring.amarchuk.model.Event;
import com.mentoring.amarchuk.model.Ticket;
import com.mentoring.amarchuk.model.User;
import com.mentoring.amarchuk.service.EventDBService;
import com.mentoring.amarchuk.service.TicketDBService;
import com.mentoring.amarchuk.service.UserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/facade")
public class FacadeController {

    public final EventDBService eventDBService;
    private TicketDBService ticketDBService;
    private UserService userService;

    public FacadeController(EventDBService eventDBService, TicketDBService ticketDBService, UserService userService) {
        this.eventDBService = eventDBService;
        this.ticketDBService = ticketDBService;
        this.userService = userService;
    }



    @GetMapping("/event")
    public String eventByIdPage(@RequestParam(value = "id" ) long id, Model model) {
        Event event=eventDBService.getEventById(id);
        model.addAttribute("message", "Event by id " +  id+" : "+event.toString());
        model.addAttribute("heading", "Event by id.");
        return "facade";
    }



    @GetMapping("/event")
    public String getEventByTitle(Model model, String title) {
        List <Event> eventsByTitle=eventDBService.getEventsByTitle(title,1,1);
        model.addAttribute("events", eventsByTitle);
        model.addAttribute("heading", "Event by title.");
        return "listOfObjects";
    }

    @GetMapping("/event")
    public String searchEventByDate(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, Model model) {
        List<Event> events = eventDBService.getEventsForDay(date,1,1);
        model.addAttribute("events",events);
        model.addAttribute("heading", "Event by Date");
        return "listOfObjects";
    }

    @GetMapping("/event")
    public String createEvent(@RequestParam("id") @DateTimeFormat(pattern = "yyyy-MM-dd") long id,
                                  @RequestParam("name")  String name,
                                  @RequestParam("date") Date date, Model model) {
        Event createEvent=new Event(id,name,date);
        Event event=eventDBService.createEvent(createEvent);
        model.addAttribute("heading", "Create new event.");
        model.addAttribute("message", event.toString());
        return "facade";
    }

//    @GetMapping("/delete/{id}")
//    public String deleteEvent(@PathVariable int id) {
//        eventDBService.deleteEvent(id);
//        return "redirect:/route";
//    }

//    @PostMapping("/update")
//    public String updateEventInDb(@RequestParam("id") @DateTimeFormat(pattern = "yyyy-MM-dd") long id,
//                                  @RequestParam("name") @DateTimeFormat(pattern = "yyyy-MM-dd") String name,
//                                  @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, Model model
//            @ModelAttribute("event") @Valid Event event, BindingResult bindingResult,
//                                      RedirectAttributes redirectAttributes) {
//
//        return "redirect:/transport";
//    }


    @GetMapping("/user")
    public String userByIdPage(@RequestParam(value = "id" ) long id, Model model) {
        User user=userService.getUserById(id);
        model.addAttribute("message", "User by id " +  id+" : "+user.toString());
        model.addAttribute("heading", "User by id.");
        return "facade";
    }

    @GetMapping("/user")
    public String userByIdPage(@RequestParam(value = "email" ) String email, Model model) {
        User user=userService.getUserByEmail(email);
        model.addAttribute("message", "User by id " +  email+" : "+user.toString());
        model.addAttribute("heading", "User by email.");
        return "facade";
    }

    @GetMapping("/user")
    public String searchEventByDate(@RequestParam("name") String name, Model model) {
        List <User> users=userService.getUsersByName(name,1,1);
        model.addAttribute("message",users);
        model.addAttribute("heading", "User by name");
        return "listOfObjects";
    }


    @GetMapping("/user")
    public String createUser(@RequestParam("id") long id,@RequestParam("name") String name,@RequestParam("email") String email, Model model) {
        User user=new User(id,name,email);
        userService.createUser(user);
        model.addAttribute("message",user.toString());
        model.addAttribute("heading", "Create new user: ");
        return "facade";
    }

    @GetMapping("/user")
    public String updateUser(@RequestParam("id") long id,@RequestParam("name") String name,@RequestParam("email") String email, Model model) {
        User user=new User(id,name,email);
        userService.updateUser(user);
        model.addAttribute("message",user.toString());
        model.addAttribute("heading", "Update user: ");
        return "facade";
    }

    @GetMapping("/user")
    public String deleteUser(@RequestParam("id") long id, Model model) {
        userService.deleteUser(id);
        String str="true";
        model.addAttribute("message",str);
        model.addAttribute("heading", "Delete user: ");
        return "facade";
    }




    @GetMapping("/ticket")
    public String bookTicket(@RequestParam(value = "id" ) long id, @RequestParam(value = "eventId" ) long eventId,
                               @RequestParam(value = "place" ) int place, @RequestParam(value = "category" ) Category category, Model model) {
        Ticket ticket=ticketDBService.bookTicket(id, eventId,place,category);
        model.addAttribute("message", "New booked ticket: " + ticket.toString());
        model.addAttribute("heading", "Book ticket.");
        return "facade";
    }

    @GetMapping("/ticket")
    public String getBookedTicketByEvent (@RequestParam("id") @DateTimeFormat(pattern = "yyyy-MM-dd") long id,
                                          @RequestParam("name")  String name,
                                          @RequestParam("date") Date date, Model model) {
        Event event=new Event(id,name,date);

        List <Ticket> tickets=ticketDBService.getBookedTickets(event,1,1);
        model.addAttribute("message", "Get booked tickets" +  tickets);
        model.addAttribute("heading", "List of booked tickets");
        return "listOfObjects";
    }

    @GetMapping("/ticket")
    public String getBookedTicket (@RequestParam("id") long id,@RequestParam("name") String name,@RequestParam("email") String email, Model model) {
        User user=new User(id,name,email);
        List <Ticket> tickets=ticketDBService.getBookedTickets(user,1,1);
        model.addAttribute("message", "Get booked tickets" +  tickets);
        model.addAttribute("heading", "List of booked tickets");
        return "listOfObjects";
    }

    @GetMapping("/ticket")
    public String cancelTicket(@RequestParam("id") long id, Model model) {
        ticketDBService.cancelTicket(id);
        model.addAttribute("message","true");
        model.addAttribute("heading", "Cancel ticket.");
        return "facade";
    }


}
