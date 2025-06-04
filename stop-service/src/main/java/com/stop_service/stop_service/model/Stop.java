package com.stop_service.stop_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Stop {
    @Id
    @GeneratedValue( strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;


    private String location;
    private String time;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public Stop() {
    }

    public Stop(Long id, String location, String time) {
        this.id = id;
        this.location = location;
        this.time = time;
    }
}
