package com.rodolfo.beltreviewerevents.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.JoinColumn;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


//imports removed for brevity
@Entity
@Table(name="users")
public class User {
 
	 @Id
	 @GeneratedValue
	 private Long id;
	 
	 @Email(message="Please provide a valid email address1")
	 @Pattern(regexp="\\A([^@\\s]+)@((?:[-a-z0-9]+\\.)+[a-z]+)\\z", message="Please provide a valid email address2")
	 private String email;
	 
	 @Size(min=1, message="Username must be greater than 1 characters")
	 private String firstName;
	 
	 @Size(min=1, message="Username must be greater than 1 characters")
	 private String lastName;
	 
	 @Size(min=1, message="Location must be greater than 1 characters")
	 private String location;
	 
	 @Size(min=1, message="State must be greater than 1 characters")
	 private String state;
	 
	 @Size(min=4, message="Password must be greater than 4 characters")
	 private String password;
	 
	 @Transient
	 private String passwordConfirmation;
	 
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 
	 @ManyToMany(fetch = FetchType.EAGER)
	 @JoinTable(
	        name = "users_roles", 
	        joinColumns = @JoinColumn(name = "user_id"), 
	        inverseJoinColumns = @JoinColumn(name = "role_id"))
	 private List<Role> roles;
	 
	 
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
	        name = "users_events", 
	        joinColumns = @JoinColumn(name = "user_id"), 
	        inverseJoinColumns = @JoinColumn(name = "event_id"))
	 private List<Event> eventsAttending;
	 
	 
	 @OneToMany(mappedBy="host", fetch = FetchType.LAZY)
	 private List<Event> events;
	 
	 @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	 private List<Message> messages;
	 
	 public User() {
	 }
	 public Long getId() {
	     return id;
	 }
	 public void setId(Long id) {
	     this.id = id;
	 }
	 public String getEmail() {
	     return email;
	 }
	 public void setEmail(String email) {
	     this.email = email;
	 }
	 public String getPassword() {
	     return password;
	 }
	 public void setPassword(String password) {
	     this.password = password;
	 }
	 public String getPasswordConfirmation() {
	     return passwordConfirmation;
	 }
	 public void setPasswordConfirmation(String passwordConfirmation) {
	     this.passwordConfirmation = passwordConfirmation;
	 }
	 public Date getCreatedAt() {
	     return createdAt;
	 }
	 public void setCreatedAt(Date createdAt) {
	     this.createdAt = createdAt;
	 }
	 public Date getUpdatedAt() {
	     return updatedAt;
	 }
	 public void setUpdatedAt(Date updatedAt) {
	     this.updatedAt = updatedAt;
	 }
	 
	 public String getFirstName() {
	     return firstName;
	 }
	 public void setFirstName(String firstName) {
	     this.firstName = firstName;
	 }
	 
	 public String getState() {
	     return state;
	 }
	 public void setState(String state) {
	     this.state = state;
	 }
	 
	 
	 public String getLocation() {
	     return location;
	 }
	 public void setLocation(String location) {
	     this.location = location;
	 }
	 
	 
	 public String getLastName() {
	     return lastName;
	 }
	 public void setLastName(String lastName) {
	     this.lastName = lastName;
	 }
	 
	 public List<Role> getRoles() {
		 return roles;
	 }
	 public void setRoles(List<Role> roles) {
		 this.roles = roles;
	 }
	 
	 public List<Event> getEventsAttending() {
		 return eventsAttending;
	 }
	 public void setEventsAttending(List<Event> eventsAttending) {
		 this.eventsAttending = eventsAttending;
	 }
	 
	 public List<Event> getEvents() {
		 return events;
	 }
	 public void setEvents(List<Event> events) {
		 this.events = events;
	 }
	 
	 public List<Message> getMessages() {
		 return messages;
	 }
	 public void setMessages(List<Message> messages) {
		 this.messages = messages;
	 }
	 
	 
	 @PrePersist
	 protected void onCreate(){
	     this.createdAt = new Date();
	 }
	 @PreUpdate
	 protected void onUpdate(){
	     this.updatedAt = new Date();
	 }
}
