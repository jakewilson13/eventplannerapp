package com.tts2.eventplannerapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts2.eventplannerapp.model.Event;
import com.tts2.eventplannerapp.model.EventDisplay;
import com.tts2.eventplannerapp.model.User;
import com.tts2.eventplannerapp.service.EventService;
import com.tts2.eventplannerapp.service.UserService;

@Controller
public class EventController {
	@Autowired
	private UserService userService;

	@Autowired
	private EventService eventService;

	@GetMapping(value= {"/events", "/"})
	  public String getFeed(@RequestParam(value="filter", required = false) String filter, 
	      Model model) {
	    User loggedInUser = userService.getLoggedInUser();
	    List<EventDisplay> events = new ArrayList<>();
	    if (filter == null) {
	      filter = "all";
	    }
	      events = eventService.findAll();
	      model.addAttribute("filter", filter);
	    
	      model.addAttribute("eventList", events);
	    return "events";
	  }

	@GetMapping(value = "/events/new")
	public String getEventForm(Model model) {
		model.addAttribute("event", new Event());
		return "newEvent";
	}

	@PostMapping(value = "/events/new")
	public String submitEventForm(@Valid Event event, BindingResult bindingResult, Model model) {
		User user = userService.getLoggedInUser();
		if (!bindingResult.hasErrors()) {
			event.setUser(user);
			eventService.save(event);
			model.addAttribute("successMessage", "Event successfully created!");
			model.addAttribute("event", new Event());
		}
		return "newEvent";
	}
}
