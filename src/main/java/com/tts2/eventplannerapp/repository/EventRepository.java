package com.tts2.eventplannerapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tts2.eventplannerapp.model.Event;
import com.tts2.eventplannerapp.model.User;



public interface EventRepository extends CrudRepository<Event, Long> {
	List<Event> findAllByOrderByCreatedAtDesc();

	List<Event> findAllByUserOrderByCreatedAtDesc(User user);

	List<Event> findAllByUserInOrderByCreatedAtDesc(List<User> users);
	
	
}
