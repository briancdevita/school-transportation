package com.transporte.route_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class Stop {

    public Stop() {
    }

    public Stop(Long id, String name, String address, String estimaedHours, Route route) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.estimaedHours = estimaedHours;
        this.route = route;
    }

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String estimaedHours;


    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEstimaedHours() {
        return estimaedHours;
    }

    public void setEstimaedHours(String estimaedHours) {
        this.estimaedHours = estimaedHours;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

}
