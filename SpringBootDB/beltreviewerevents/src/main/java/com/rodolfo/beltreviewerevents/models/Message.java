package com.rodolfo.beltreviewerevents.models;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="messages")
public class Message {

	@Id
    @GeneratedValue
    private Long id;
	
	@Size(min=1, message="Content must be greater than 1 characters")
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="event_id")
    private Event event;
	
	 // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    public Message() {
	}
	
    
    public Long getId() {
	     return id;
	 }
	 public void setId(Long id) {
	     this.id = id;
	 }
	 public String getContent() {
	     return content;
	 }
	 public void setContent(String content) {
	     this.content = content;
	 }
	 
	 public User getUser() {
	     return user;
	 }
	 public void setUser(User user) {
	     this.user = user;
	 }
	 
	 public Event getEvent() {
	     return event;
	 }
	 public void setEvent(Event event) {
	     this.event = event;
	 }
}
