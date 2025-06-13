package com.transporte.student.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;



@Entity

public class Student {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;


    private String firstName;
    private Long routeId;
    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    private String lastName;
    private String address;
    private String assignedStop;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, String address, String assignedStop) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.assignedStop = assignedStop;
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

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

public String getAssignedStop() {
    return assignedStop;
}

public void setAssignedStop(String assignedStop) {
    this.assignedStop = assignedStop;
}

    
}
