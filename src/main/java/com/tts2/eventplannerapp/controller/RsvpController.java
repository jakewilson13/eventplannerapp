package com.tts2.eventplannerapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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


	@PostMapping(value = "/event/{enabled}")
	public String rsvp(@PathVariable(value = "enabled") String username, Event event, Boolean enabled, Long id, HttpServletRequest request,
			Model model) {
		User user = userService.getLoggedInUser();
		enabled = event.getRsvp();
		List<EventDisplay> events = eventService.findAllByUser(user);
//		Boolean rsvp = true;
	  //if(enabled.equals(enabled))	
		if(enabled == false) {
		event.setRsvp(true);
		eventService.save(event);
		System.out.println("hello");
		model.addAttribute("rsvp", enabled);
		} else {
			event.setRsvp(false);
		}
		return "redirect:" + request.getHeader("Referer");
	}

//	@PostMapping(value = "/unrsvp/{event}")
//	public String unrsvp(@PathVariable(value = "event") String username, Long id, HttpServletRequest request) {
//		User loggedInUser = userService.getLoggedInUser();
//		
//		Event eventToRsvp = eventService.findEventById(id);
//		eventToRsvp.
//		userService.save(evenToUnRsvp);
//		return "redirect:" + request.getHeader("Referer");
//	}
}


