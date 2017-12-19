package com.events.sample.service;

import com.events.sample.model.Events;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EventsService {

    public void saveEvent(Events event);
    public List<Events> getAllEvents();
    public ResponseEntity<Events> getEventsById(Long id);
    public ResponseEntity<Events> updateEvents(Long id);
    public ResponseEntity<Events> deleteEvents(Long id);
}

