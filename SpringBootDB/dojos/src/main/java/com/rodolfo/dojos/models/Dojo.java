package com.rodolfo.dojos.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="dojos")
public class Dojo {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninjas;
    
    
    
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
    
    
    public Dojo() {
        
    }
    
    public Dojo(String name) {
    	this.name = name;       
    }
    public Long getId() {
        return id;
    }    
    public void setId(long id) {
        this.id =  id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name =  name;
    }
    
    public List<Ninja> getNinjas() {
        return ninjas;
    }
    public void setNinjas(Ninja ninja) {
        ninjas.add(ninja);
    }
    
}
