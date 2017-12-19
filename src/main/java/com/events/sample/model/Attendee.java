package com.events.sample.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
public class Attendee {

    @Id
    @GeneratedValue
    @Column(name = "attendee_id")
    private Long id;
    @Column(name = "attendee_name")
    private String attendeeName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "events_id", nullable = false)
    @JsonBackReference
    private Events events;

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public Attendee() {

    }

    public Attendee(String attendeeName, Events events) {
        this.attendeeName = attendeeName;
        this.events = events;
    }

    public Attendee(String attendeeName) {
        this.attendeeName = attendeeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    public void setAttendeeName(String attendeeName) {
        this.attendeeName = attendeeName;
    }

}
