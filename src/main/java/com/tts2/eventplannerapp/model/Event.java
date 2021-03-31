package com.tts2.eventplannerapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "event_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	private String message;
	
//	@JoinTable(name = "rsvp_id", joinColumns = @JoinColumn(name = "user_id"),
//			inverseJoinColumns = @JoinColumn(name = "event_id"))
	private Boolean rsvp = false;
	
	
	@CreationTimestamp
	private Date createdAt;

	
	
	public Event() {}
	
	
	
	
	public Event(User user, String message, Boolean rsvp, Date createdAt) {
		this.user = user;
		this.message = message;
		this.rsvp = rsvp;
		this.createdAt = createdAt;
	}


	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public Boolean getRsvp() {
		return rsvp;
	}


	public void setRsvp(Boolean rsvp) {
		this.rsvp = rsvp;
	}




	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", user=" + user + ", message=" + message + ", rsvp=" + rsvp + ", createdAt="
				+ createdAt + "]";
	}
}
