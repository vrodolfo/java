package com.rodolfo.relationships.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="persons")
public class Person {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column
	@Size(min = 5, max = 255)
    private String firstName;
    
    @Column
	@Size(min = 5, max = 255)
    private String lastName;

    @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private License license;
    
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
    
    public Person() {
        
    }
    
    public Person(String firstName, String lastName, License license) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.license = license;
        
    }
    public Long getId() {
        return id;
    }    
    public void setId(long id) {
        this.id =  id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName =  firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName =  lastName;
    }
    
    public License getLicense() {
        return license;
    }
    public void setLicense(License license) {
        this.license =  license;
    }
}
