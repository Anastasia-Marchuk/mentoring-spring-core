package com.mentoring.amarchuk.web.controller;

import com.mentoring.amarchuk.model.Event;
import com.mentoring.amarchuk.service.EventDBService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/event")
public class EventController {

    public final EventDBService eventDBService;

    public EventController(EventDBService eventDBService) {
        this.eventDBService = eventDBService;
    }

    @GetMapping("/")
    public String welcomePage(Model model) {
        model.addAttribute("welcome", "Welcome for everyone!");
        return "welcome";
    }

    @GetMapping("/id")
    public String eventByIdPage(@RequestParam(value = "id" ) long id, Model model) {
        Event event=eventDBService.getEventById(id);
        model.addAttribute("event", "Event by id " +  id+" : "+event.toString());
        model.addAttribute("heading", "Event by id.");
        return "event_by_id";
    }



    @GetMapping("/title")
    public String getEventByTitle(Model model, String title) {
        List <Event> eventsByTitle=eventDBService.getEventsByTitle(title,1,1);
        model.addAttribute("events", eventsByTitle);
        model.addAttribute("heading", "Event by title.");
        return "listOfEvents";
    }

    @GetMapping("/search")
    public String searchEventtByDate(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, Model model) {
        List<Event> events = eventDBService.getEventsForDay(date,1,1);
        model.addAttribute("events",events);
        model.addAttribute("heading", "Event by Date");
        return "listOfEvents";
    }

    @GetMapping("/create")
    public String createEvent(@RequestParam("id") @DateTimeFormat(pattern = "yyyy-MM-dd") long id,
                                  @RequestParam("name")  String name,
                                  @RequestParam("date") Date date, Model model) {
        Event createEvent=new Event(id,name,date);
        Event event=eventDBService.createEvent(createEvent);
        model.addAttribute("heading", "Create new event.");
        model.addAttribute("event", event.toString());
        return "create_event";
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


}
