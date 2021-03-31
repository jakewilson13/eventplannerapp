package com.tts2.eventplannerapp.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts2.eventplannerapp.model.Event;
import com.tts2.eventplannerapp.model.EventDisplay;
import com.tts2.eventplannerapp.model.User;
import com.tts2.eventplannerapp.service.EventService;
import com.tts2.eventplannerapp.service.UserService;


@Controller
public class RsvpController {
	@Autowired
	private UserService userService;
	
	@Autowired
	EventService eventService;


	@PostMapping(value = "/event/rsvp/{id}")
    public String rsvp(@RequestParam String submit, @PathVariable Long id, Event event, Model model) {
        //getting the event by Id
        Optional<Event> eventToRsvp = Optional.ofNullable(eventService.findEventById(id));
        if(submit.equals("up")) {
            if(eventToRsvp != null) {
                event.setRsvp(true);
                eventService.save(event);
                model.addAttribute("eventToRsvp", eventToRsvp);
            } 
            
        }
        return "events";
    }
}


