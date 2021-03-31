package com.tts2.eventplannerapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
//        model.addAttribute("event", new Event());
        //getting the event by Id
//        Optional<Event> eventToRsvp = Optional.ofNullable(eventService.findEventById(id));
        Event eventToRsvp = eventService.findEventById(id);
        System.out.println(eventToRsvp);
        // accessing the currently logged in user
        User loggedInUser = userService.getLoggedInUser();

        if(submit.equals("up")) {
            System.out.println("submission works!");
            if(eventToRsvp != null) {
                //Set's contain no duplicate elements
                Set<Event> rsvp = loggedInUser.getRsvp();
                // below is how we rsvp
                rsvp.add(eventToRsvp);
                loggedInUser.setRsvp(rsvp);
                userService.save(loggedInUser);
                model.addAttribute("eventToRsvp", eventToRsvp);
                model.addAttribute("messageSuccess", "Succesfully RSVP'd!");
            }
        }
        return "events";
    }
}



