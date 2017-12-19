package com.events.sample.controller;

import com.events.sample.model.Attendee;
import com.events.sample.service.AttendeeService;
import com.events.sample.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttendeeController {

    @Autowired
    AttendeeService attendeeService;

    @Autowired
    EventsService eventsService;

    //CREATE - add attendee
    @PostMapping("/attendee")
    public Attendee createAttendee(@RequestBody Attendee attendee) {
        attendeeService.saveAttendee(attendee);
        return attendee;
    }

    //READ - Get all Attendee
    @GetMapping("/attendee")
    public List<Attendee> findAllAttendee(){
        return attendeeService.getAllAttendee();
    }

    // Get a single event
    @GetMapping("/attendee/{id}")
    public ResponseEntity<Attendee> findOne(@PathVariable(value = "id") Long attendeeId) {
        return attendeeService.getAttendeeById(attendeeId);
    }

    //UPDATE
    @PutMapping("/attendee/{id}")
    public ResponseEntity<Attendee> updateAttendee(@RequestBody Attendee attendee, @PathVariable Long attendeeId) {
        return attendeeService.updateAttendee(attendeeId);
    }

    //DELETE
    @DeleteMapping("/attendee/{id}")
    public ResponseEntity<Attendee> deleteAttendee(@PathVariable(value = "id") Long attendeeId){
        return attendeeService.deleteAttendee(attendeeId);
    }

}
