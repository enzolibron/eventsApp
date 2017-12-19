package com.events.sample.model;

import javax.persistence.*;

@Entity
public class Attendee {

    @Id
    @GeneratedValue
    @Column(name = "attendee_id")
    private Long id;

    @Column(name = "attendee_name")
    private String attendeeName;

    @Column(name = "events_id")
    private int events_id;


    public int getEvents_id() {
        return events_id;
    }

    public void setEvents_id(int events_id) {
        this.events_id = events_id;
    }

    public Attendee() {

    }

    public Attendee(String attendeeName, int events_id) {
        this.attendeeName = attendeeName;
        this.events_id = events_id;
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
