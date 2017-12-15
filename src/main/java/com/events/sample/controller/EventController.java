package com.events.sample.controller;

import com.events.sample.model.Events;
import com.events.sample.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController  {

    @Autowired
    EventsService eventsService;

    @PostMapping("/events/add")
    public void addEvents(@RequestBody Events events) {
        eventsService.saveEvent(events);
    }

    @GetMapping("/events")
    public List<Events> findAll(){
        return eventsService.getAllEvents();
    }

}
