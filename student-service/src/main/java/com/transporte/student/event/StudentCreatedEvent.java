package com.transporte.student.event;




public class StudentCreatedEvent {
    private Long id;
    private String firstName;

    public StudentCreatedEvent() {
    }

    public StudentCreatedEvent(Long id, String firstName) {
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
