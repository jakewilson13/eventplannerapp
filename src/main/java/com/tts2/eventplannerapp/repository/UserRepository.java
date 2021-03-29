package com.tts2.eventplannerapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts2.eventplannerapp.model.User;
	@Repository
	public interface UserRepository extends CrudRepository<User, Long> {
		User findByUsername(String username);
		
	}
