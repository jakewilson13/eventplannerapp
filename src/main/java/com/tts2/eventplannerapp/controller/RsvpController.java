package com.tts2.eventplannerapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

//    public String follow(@PathVariable String username, HttpServletRequest request) {
//        User loggedInUser = userService.getLoggedInUser();
//        User userToFollow = userService.findByUsername(username);
//
//        List<User> followers = userToFollow.getFollowers();
//        followers.add(loggedInUser);
//        userToFollow.setFollowers(followers);
//        userService.save(userToFollow);
//        return "redirect:" + request.getHeader("Referer");
//    }

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
////              eventToRsvp.setUser(loggedInUser);
//                eventToRsvp.setRsvp(true);
                Set<Event> rsvp = loggedInUser.getRsvp();
                // below is how we rsvp
                rsvp.add(eventToRsvp);
                loggedInUser.setRsvp(rsvp);
//                eventService.save(loggedInUser);
                userService.save(loggedInUser);
                model.addAttribute("eventToRsvp", eventToRsvp);
            }
        }
        return "events";
    }
}


