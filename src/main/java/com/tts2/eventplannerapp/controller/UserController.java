package com.tts2.eventplannerapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private EventService eventService;

	@GetMapping(value = "/users/{username}")
	public String getUser(@PathVariable(value = "username") String username, Model model) {
		User user = userService.findByUsername(username);
		List<EventDisplay> events = eventService.findAllByUser(user);
		User loggedInUser = userService.getLoggedInUser();

//		boolean isRsvpd = false;

		boolean isSelfEvent = loggedInUser.getUsername().equals(username);
//		model.addAttribute("isSelfEvent", isSelfEvent);
//		model.addAttribute("isRsvpd", isRsvpd);
		model.addAttribute("eventList", events);
		model.addAttribute("user", user);
		return "user";
	}

	@GetMapping(value = "/users")
	public String getUsers(@RequestParam(value = "filter", required = false) String filter, Model model) {
		List<User> users = new ArrayList<>();
		User loggedInUser = userService.getLoggedInUser();
		if (filter == null) {
			filter = "all";
		}
		 else {
			users = userService.findAll();
			model.addAttribute("filter", filter);
		}
		model.addAttribute("users", users);
		setEventCounts(users, model);
		return "users";
	}
	
	private void setEventCounts(List<User> users, Model model) {
		HashMap<String, Integer> eventCounts = new HashMap<>();
		for (User user : users) {
			List<EventDisplay> events = eventService.findAllByUser(user);
			eventCounts.put(user.getUsername(), events.size());
		}
		model.addAttribute("eventCounts", eventCounts);
	}
}

