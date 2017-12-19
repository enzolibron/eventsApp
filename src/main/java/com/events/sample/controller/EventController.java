package com.events.sample.controller;

import com.events.sample.model.Events;
import com.events.sample.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController  {

    @Autowired
    EventsService eventsService;

    //CREATE - add event
    @PostMapping("/events")
    public Events createEvents(@RequestBody Events events) {
        eventsService.saveEvent(events);
        return events;
    }

    //READ - Get all Events
    @GetMapping("/events")
    public List<Events> findAllEvents(){
        return eventsService.getAllEvents();
    }

    // Get a single event
    @GetMapping("/events/{id}")
    public ResponseEntity<Events> findOne(@PathVariable(value = "id") Long eventId) {
        return eventsService.getEventsById(eventId);
    }

    //UPDATE
    @PutMapping("/events/{id}")
    public ResponseEntity<Events> updateEvents(@RequestBody Events events, @PathVariable Long eventId) {
        return eventsService.updateEvents(eventId);
    }

    //DELETE
    @DeleteMapping("/events/{id}")
    public ResponseEntity<Events> deleteEvents(@PathVariable(value = "id") Long eventId){
        return eventsService.deleteEvents(eventId);
    }

}
