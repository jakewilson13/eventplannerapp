package com.tts2.eventplannerapp.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts2.eventplannerapp.model.Event;
import com.tts2.eventplannerapp.model.User;


@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	List<Event> findAllByOrderByCreatedAtDesc();

	List<Event> findAllByUserOrderByCreatedAtDesc(User user);

	List<Event> findAllByUserInOrderByCreatedAtDesc(List<User> users);

	Optional<Event> findById(Long id);

}
