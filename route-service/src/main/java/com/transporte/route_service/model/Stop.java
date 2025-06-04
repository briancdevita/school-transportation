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

}
