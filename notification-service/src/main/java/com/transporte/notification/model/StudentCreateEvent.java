package com.transporte.notification.model;

public class StudentCreateEvent {
    
    private Long id;
    private String firstName;

    public StudentCreateEvent() {
    }

    public StudentCreateEvent(Long id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
