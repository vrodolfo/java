package com.rodolfo.selfjoin.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="employees")
public class Employee {
	@Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    
    
    @OneToMany(mappedBy="manager", fetch = FetchType.LAZY)
    private List<Employee> employees;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="manager_id")
    private Employee manager;
	
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
    
    public Employee() {
    	
    }
    
    public Employee(String firstname, String lastName) {
    	this.firstName = firstname;
    	this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }    
    public void setId(long id) {
        this.id =  id;
    }
    
    
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    
    public Employee getManager() {
        return manager;
    }
    public void setManager(Employee employee) {
        this.manager = employee;
    }
    
    public String getFirstname() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastname() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    
    
}
