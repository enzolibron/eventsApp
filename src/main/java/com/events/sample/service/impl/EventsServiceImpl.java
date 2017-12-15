package com.events.sample.service.impl;

import com.events.sample.model.Events;
import com.events.sample.repository.EventsRepository;
import com.events.sample.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Events getEventById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Events> getAllEvents() {
        return repository.findAll();
    }
}
