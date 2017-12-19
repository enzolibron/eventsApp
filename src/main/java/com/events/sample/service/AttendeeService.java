package com.events.sample.service;

import com.events.sample.model.Attendee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AttendeeService {

    public void saveAttendee(Attendee attendee);
    public List<Attendee> getAllAttendee();
    public ResponseEntity<Attendee> getAttendeeById(Long id);
    public ResponseEntity<Attendee> updateAttendee(Long id);
    public ResponseEntity<Attendee> deleteAttendee(Long id);
}
