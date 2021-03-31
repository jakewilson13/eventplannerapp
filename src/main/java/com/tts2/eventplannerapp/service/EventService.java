package com.tts2.eventplannerapp.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts2.eventplannerapp.model.Event;
import com.tts2.eventplannerapp.model.EventDisplay;
import com.tts2.eventplannerapp.model.User;
import com.tts2.eventplannerapp.repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired 
	UserService userService;


	public Event findEventById(Long id) {
		Optional<Event> optionalEvent = eventRepository.findById(id);

		Event event = null;

		if(optionalEvent.isPresent()) {
			event = optionalEvent.get();
			return event;
		} else {
			return event;
		}
	}
	
	public List<EventDisplay> findAll() {
	    List<Event> events = eventRepository.findAllByOrderByCreatedAtDesc();
	    return formatEvents(events);
	}
		
	public List<EventDisplay> findAllByUser(User user) {
	    List<Event> events = eventRepository.findAllByUserOrderByCreatedAtDesc(user);
	    return formatEvents(events);
	}
		
	public List<EventDisplay> findAllByUsers(List<User> users){
	    List<Event> events = eventRepository.findAllByUserInOrderByCreatedAtDesc(users);
	    return formatEvents(events);
	}
	
	public void save (Event event) {
		eventRepository.save(event);
	}


	private List<EventDisplay> formatEvents(List<Event> events) {
		List<EventDisplay> displayEvents = formatTimestamps(events);
		return displayEvents;
	}

	private List<EventDisplay> formatTimestamps(List<Event> events) {
		List<EventDisplay> response = new ArrayList<>();
		PrettyTime prettyTime = new PrettyTime();
		SimpleDateFormat simpleDate = new SimpleDateFormat("M/d/yy");
		Date now = new Date();
		for (Event event : events) {
			EventDisplay eventDisplay = new EventDisplay();
			eventDisplay.setUser(event.getUser());
			eventDisplay.setMessage(event.getMessage());
			long diffInMillies = Math.abs(now.getTime() - event.getCreatedAt().getTime());
			long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			if (diff > 3) {
				eventDisplay.setDate(simpleDate.format(event.getCreatedAt()));
			} else {
				eventDisplay.setDate(prettyTime.format(event.getCreatedAt()));
			}
			response.add(eventDisplay);
		}
		return response;
	}
	
	
//	public boolean alreadyRsvpd(Event e) {
//		boolean alreadyRsvpd = false;
//		for(Boolean rsvpd : e.getRsvp()) {
//			String username = userService.getLoggedInUser().getUsername();
//			if(rsvpd.equals(username)) {
//				alreadyRsvpd = true;
//				break;
//			}
//		}
//		return alreadyRsvpd;
//	}


}
