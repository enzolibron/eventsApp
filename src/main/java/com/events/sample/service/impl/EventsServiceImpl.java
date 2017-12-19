package com.events.sample.service.impl;

import com.events.sample.model.Events;
import com.events.sample.repository.EventsRepository;
import com.events.sample.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsServiceImpl implements EventsService {

    @Autowired
    EventsRepository repository;

    @Override
    public void saveEvent(Events event) {
        repository.save(event);
    }

    @Override
    public ResponseEntity<Events> getEventsById(Long id) {
        Events events = repository.findOne(id);
        if(events == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(events);
    }

    @Override
    public List<Events> getAllEvents() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Events> updateEvents(Long id) {
        Events events = repository.findOne(id);
        if(events == null){
            return ResponseEntity.notFound().build();
        }
        events.setEventName(events.getEventName());
        events.setId(events.getId());

        Events updatedEvents = repository.save(events);
        return ResponseEntity.ok(updatedEvents);
    }

    @Override
    public ResponseEntity<Events> deleteEvents(Long id) {
        Events events = repository.findOne(id);
        if(events == null){
            return ResponseEntity.notFound().build();
        }
        repository.delete(id);
        return ResponseEntity.ok().build();
    }
}
