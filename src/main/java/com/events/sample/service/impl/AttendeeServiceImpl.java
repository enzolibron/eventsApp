package com.events.sample.service.impl;

import com.events.sample.model.Attendee;
import com.events.sample.repository.AttendeeRepository;
import com.events.sample.service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeServiceImpl implements AttendeeService {

    @Autowired
    AttendeeRepository attendeeRepository;

    @Override
    public void saveAttendee(Attendee attendee) {
        attendeeRepository.save(attendee);
    }

    @Override
    public ResponseEntity<Attendee> getAttendeeById(Long id) {
        Attendee attendee = attendeeRepository.findOne(id);
        if(attendee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(attendee);
    }

    @Override
    public List<Attendee> getAllAttendee() {
        return attendeeRepository.findAll();
    }

    @Override
    public ResponseEntity<Attendee> updateAttendee(Long id) {
        Attendee attendee = attendeeRepository.findOne(id);
        if(attendee == null){
            return ResponseEntity.notFound().build();
        }
        attendee.setAttendeeName(attendee.getAttendeeName());
        attendee.setId(attendee.getId());

        Attendee updatedAttendee = attendeeRepository.save(attendee);
        return ResponseEntity.ok(updatedAttendee);
    }

    @Override
    public ResponseEntity<Attendee> deleteAttendee(Long id) {
        Attendee attendee = attendeeRepository.findOne(id);
        if(attendee == null){
            return ResponseEntity.notFound().build();
        }
        attendeeRepository.delete(id);
        return ResponseEntity.ok().build();
    }
}
