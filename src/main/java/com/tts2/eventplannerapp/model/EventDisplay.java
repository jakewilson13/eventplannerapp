package com.tts2.eventplannerapp.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;


public class EventDisplay {

	@Id
	@JoinTable(name = "EVENT")
	private Long id;

	@JoinColumn(name = "user_id")
	private User user;

	private String message;
	private String date;
	
	
	public EventDisplay() {}
	
	
	public EventDisplay(User user, String message, String date) {
		this.user = user;
		this.message = message;
		this.date = date;
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