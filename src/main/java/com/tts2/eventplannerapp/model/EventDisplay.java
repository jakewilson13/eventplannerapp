package com.tts2.eventplannerapp.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;


public class EventDisplay {

//	@Id
//	@JoinTable(name = "EVENT")
	private Long id;

	@JoinColumn(name = "user_id")
	private User user;

	private String date;
	private String message;


	public EventDisplay() {}
	
	
	public EventDisplay(User user, String date, String message) {
		this.user = user;
		this.date = date;
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "TweetDisplay [user=" + user + ", message=" + message + ", date=" + date +"]";
	}



}