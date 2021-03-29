package com.tts2.eventplannerapp.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;


@Entity
public class User {
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "user_id")
	  private Long id;

	  @Email(message = "Please provide a valid email")
	  @NotEmpty(message = "Please provide an email")
	  private String email;

	  @Length(min = 3, message = "A username must have at least 3 characters")
	  @Length(max = 15, message = "A username cannot have more than 15 characters")
	  @Pattern(regexp = "[^\\s]+", message = "A username cannot contain spaces")
	  private String username;

	  @Length(min = 5, message = "A password must have at least 5 characters")
	  private String password;

	  @NotEmpty(message = "Please provide your first name")
	  private String firstName;

	  @NotEmpty(message = "Please provide your last name")
	  private String lastName;

	  private Integer active;

	  @CreationTimestamp
	  private Date createdAt;

	  @ManyToMany(cascade = CascadeType.ALL)
	  @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), 
	  inverseJoinColumns = @JoinColumn(name = "role_id"))
	  private Set<Role> roles;
	  
	  public User() {}
	  
	  
	public User(
			@Email(message = "Please provide a valid email") @NotEmpty(message = "Please provide an email") String email,
			@Length(min = 3, message = "A username must have at least 3 characters") @Length(max = 15, message = "A username cannot have more than 15 characters") @Pattern(regexp = "[^\\s]+", message = "A username cannot contain spaces") String username,
			@Length(min = 5, message = "A password must have at least 5 characters") String password,
			@NotEmpty(message = "Please provide your first name") String firstName,
			@NotEmpty(message = "Please provide your last name") String lastName, Integer active, Date createdAt,
			Set<Role> roles) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.active = active;
		this.createdAt = createdAt;
		this.roles = roles;
	}

	
	
	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", active=" + active + ", createdAt="
				+ createdAt + ", roles=" + roles + "]";
	}	  
}
