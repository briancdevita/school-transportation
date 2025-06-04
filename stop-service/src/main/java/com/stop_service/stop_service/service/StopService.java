package com.stop_service.stop_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stop_service.stop_service.model.Stop;
import com.stop_service.stop_service.repository.StopRepository;

@Service
public class StopService {

    private final StopRepository stopRepository;

    public StopService(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }


    public Stop save(Stop stop) {
        return stopRepository.save(stop);
    }

    public List<Stop> getAll() {
        return stopRepository.findAll();
    }

    public void deleteById(Long id) {
        stopRepository.deleteById(id);
    }



    
}
