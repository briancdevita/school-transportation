package com.transporte.route_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.transporte.route_service.model.Route;
import com.transporte.route_service.service.RouteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;





@RestController
@RequestMapping("/api/routes")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class RouteController {


    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }


    @PostMapping()
    public Route create (@RequestBody Route route) {
        return routeService.save(route);
    }
    

    @GetMapping()
    public List<Route> getAll() {
        return routeService.getAll();
    

    
}}
