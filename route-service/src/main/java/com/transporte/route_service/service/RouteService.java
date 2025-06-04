package com.transporte.route_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.transporte.route_service.model.Route;
import com.transporte.route_service.repository.RouteRepository;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route save (Route route) {
        return routeRepository.save(route);
    }

    public List<Route> getAll() {
        return routeRepository.findAll();
    }
    
}
