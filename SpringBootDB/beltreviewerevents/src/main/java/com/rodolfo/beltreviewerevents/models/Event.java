package com.rodolfo.beltreviewerevents.models;
import java.util.Date;
import java.util.Iterator;
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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name="events")
public class Event {
	
	@Id
    @GeneratedValue
    private Long id;
	
	@Size(min=1, message="Name must be greater than 1 characters")
	private String name;
	 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	 
	@Size(min=1, message="Location must be greater than 1 characters")
	private String location;
	 
	@Size(min=1, message="State must be greater than 1 characters")
	private String state;
    
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "users_events", 
	        joinColumns = @JoinColumn(name = "event_id"), 
	        inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User host;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	 private List<Message> messages;
    
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
    
    public Event() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
	    this.id = id;
	}
	public String getName() {
	     return name;
	}
	public void setName(String name) {
	     this.name = name;
	 }
	
	public Date getDate() {
	     return date;
	}
	public void setDate(Date date) {
	     this.date = date;
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
	 
	 public List<User> getUsersAttending() {
		 return users;
	 }
	 public void setUsersAttending(List<User> usersAttending) {
		 this.users = usersAttending;
	 }
	 
	 public List<Message> getMessages() {
		 return messages;
	 }
	 public void setMessages(List<Message> messages) {
		 this.messages = messages;
	 }
	 
	 public void addMessage(Message message) {
		 messages.add(message);
	 }
	 
	 public User getHost() {
		 return host;
	 }
	 
	 public void setHost(User host) {
		 this.host = host;
	 }
	 
	 public boolean checkIfJoining(User user) {
		 User temp;
		 for (int i = 0; i < users.size(); i++) {
			 temp = users.get(i);
			 if (temp.getId() == user.getId()) {
				 return true;
			 }
		}
		return false;
	 }
	 
	 public void addAttendee(User user) {
		 users.add(user);
	 }
	 
	 public void cancelJoin(User user) {
		 Iterator<User> i = users.iterator();
		 while (i.hasNext()) {
		    User o = i.next();
		   //some condition
		    if (o.getId() == user.getId()) {
		    	i.remove();
			 }
		     
		 }
	 }
	 

}
