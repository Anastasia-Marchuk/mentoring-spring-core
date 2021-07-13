package com.mentoring.amarchuk.web.controller;

import com.mentoring.amarchuk.model.Event;
import com.mentoring.amarchuk.service.EventDBService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/accept=application/pdf")
public class PDFController {

    public final EventDBService eventDBService;

    public PDFController(EventDBService eventDBService) {
        this.eventDBService = eventDBService;
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getDownloadData(@RequestParam("title") String title) throws Exception {
        List <Event> eventsByTitle=eventDBService.getEventsByTitle(title,1,1);
        StringBuilder builder=new StringBuilder("");
        for (Event e : eventsByTitle) {
            builder.append(e.toString()+"\n");
        }
        String regData = builder.toString();

        byte[] output = regData.getBytes();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("charset", "utf-8");
        responseHeaders.setContentType(MediaType.valueOf("text/html"));
        responseHeaders.setContentLength(output.length);
        responseHeaders.set("Content-disposition", "attachment; filename=filename.txt");

        return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
    }



//    @GetMapping("/download")
//    public String searchEventtByDate(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, Model model) {
//        List <Event> eventsByTitle=eventDBService.getEventsForDay(date,1,1);
//        StringBuilder builder=new StringBuilder("");
//        for (Event e : eventsByTitle) {
//            builder.append(e.toString()+"\n");
//        }
//        String regData = builder.toString();
//
//        byte[] output = regData.getBytes();
//
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.set("charset", "utf-8");
//        responseHeaders.setContentType(MediaType.valueOf("text/html"));
//        responseHeaders.setContentLength(output.length);
//        responseHeaders.set("Content-disposition", "attachment; filename=filename.txt");
//
//        return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
//    }




}
