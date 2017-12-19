package com.events.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "events")
public class Events {

    @Id
    @GeneratedValue
    @Column(name = "events_id")
    private Long id;
    @Column(name = "event_name")
    private String eventName;

    @JsonProperty(value = "attendeeList")
    @OneToMany(targetEntity = Attendee.class, mappedBy = "events",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attendee> attendeeList;

    public List<Attendee> getAttendeeList() {
        return attendeeList;
    }

    public void setAttendeeList(List<Attendee> attendeeList) {
        this.attendeeList = attendeeList;
    }

    public Events(){

    }

    public Events(String eventName) {
        this.eventName = eventName;
    }

    public Events(String eventName, List<Attendee> attendeeList) {
        this.eventName = eventName;
        this.attendeeList = attendeeList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
