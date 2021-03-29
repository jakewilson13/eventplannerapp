package com.tts2.eventplannerapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts2.eventplannerapp.model.Role;



@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByRole(String role);
}
