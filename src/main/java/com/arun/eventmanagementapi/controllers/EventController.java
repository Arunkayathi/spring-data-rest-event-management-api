package com.arun.eventmanagementapi.controllers;


import com.arun.eventmanagementapi.entities.Event;
import com.arun.eventmanagementapi.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RepositoryRestController
@RequestMapping("/events")
public class EventController {
    
    @Autowired
    private EventRepository eventRepository;

    @PostMapping("/start/{id}")
    public ResponseEntity startEvent(@PathVariable("id") Long id){
        Optional<Event> event = eventRepository.findById(id);
        if(!event.isPresent()){
            throw new ResourceNotFoundException();
        }
        Event selectedEvent= event.get();
        selectedEvent.setStarted(true);
        eventRepository.save(selectedEvent);
        return ResponseEntity.ok(selectedEvent.getName()+" event has started");
    }

}
