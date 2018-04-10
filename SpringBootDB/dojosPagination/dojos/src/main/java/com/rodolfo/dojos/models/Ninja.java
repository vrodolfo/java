package com.rodolfo.dojos.models;

import com.rodolfo.dojos.models.Dojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class Ninja {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;
    
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
    
    public Ninja() {
        
    }
    
    public Ninja(String firstName, String lastName, Dojo dojo) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.dojo = dojo;
        
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
    
    public Dojo getDojo() {
        return dojo;
    }
    public void setDojo(Dojo dojo) {
        this.dojo =  dojo;
    }
}
