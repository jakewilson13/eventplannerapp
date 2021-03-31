package com.tts2.eventplannerapp.controller;

import com.tts2.eventplannerapp.model.Event;
import com.tts2.eventplannerapp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulController {

    @Autowired
    private EventService eventService;

    @GetMapping(value = "/event/rest/{id}")
    public Event getEvent(@PathVariable Long id) {
        return eventService.findEventById(id);
    }
}
