package com.rodolfo.relationships.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
//...
@Entity
@Table(name="licenses")
public class License {
 
	 @Id
	 @GeneratedValue
	 private Long id;
	 
	 private String number;
	 
	 
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date expiration_date;
	 private String state;
	 @OneToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="person_id")
	 private Person person;
	 
	//This will not allow the createdAt column to be updated after creation
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
	 
	 public License() {
	     
	 }
	 
	 public License(String number, Date expiration_date, String state) {
	     //this.number = Long.toString(this.id);
	     this.expiration_date = expiration_date;
	     this.state = state;
	 }
	 
	 public Long getId() {
	     return id;
	 }
	 
	 public String getNumber() {
	     return number;
	 }    
	 public void setNumber(String number) {
	     this.number =  number;
	 }
	 
	 public Date getExpiration_date() {
	     return expiration_date;
	 }    
	 public void setExpiration_date(Date expiration_date) {
	     this.expiration_date =  expiration_date;
	 }
	 
	 public String getState() {
	     return state;
	 }
	 
	 public Person getPerson() {
	     return person;
	 }
	 
	 public void setPerson(Person person) {
	     this.person = person;
	 }
	 
	 public void setState(String state) {
	     this.state =  state;
	 }
	 
 
 // ...
 // getters and setters removed for brevity
 // ...
}

