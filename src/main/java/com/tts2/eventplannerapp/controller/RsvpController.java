package com.tts2.eventplannerapp.controller;

import java.util.List;

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


	//{enabled} is not correct
	// get event user wants to rsvp for
	
//	@PostMapping(value = "/event/{id}")
//	public String rsvp(@PathVariable (value = "id") Long id,  @RequestParam String submit, Event event, HttpServletRequest request,
//			Model model) {
//		//getting the event by Id
//		Event eventToRsvp = eventService.findEventById(id);
//		if(submit.equals("up")) {
//			System.out.println("hello");
//			if(eventToRsvp != null) {
//				event.setRsvp(true);
//				eventService.save(event);
//				model.addAttribute("eventToRsvp", eventToRsvp);
//			} 
//			
//		}
//		return "redirect:" + request.getHeader("Referer");
//	}
}


