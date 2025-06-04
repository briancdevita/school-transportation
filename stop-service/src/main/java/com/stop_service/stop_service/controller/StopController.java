package com.stop_service.stop_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stop_service.stop_service.model.Stop;
import com.stop_service.stop_service.service.StopService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/stops")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class StopController {

    private final StopService stopService;
    public StopController(StopService stopService) {
        this.stopService = stopService;
    }
    

    @PostMapping()
    public Stop save(@RequestBody Stop stop) {
        return stopService.save(stop);
    }

    @GetMapping()
    public List<Stop> getAll() {
        return stopService.getAll();
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
      stopService.deleteById(id);
    }
    
    
    
}
