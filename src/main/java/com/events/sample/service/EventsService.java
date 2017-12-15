package com.events.sample.service;

import com.events.sample.model.Events;

import java.util.List;

public interface EventsService {

    public void saveEvent(Events event);
    public Events getEventById(Long id);
    public List<Events> getAllEvents();

}

