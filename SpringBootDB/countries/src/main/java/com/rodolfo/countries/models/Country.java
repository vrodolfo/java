package com.rodolfo.countries.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.rodolfo.countries.models.City;

@Entity
@Table(name="countries")
public class Country {
	 @Id
	 @GeneratedValue
	 private Long id;
	 
	 private String code;
	 private String name;
	 private String continent;
	 private String region;
	 private Long surface_area;
	 private int indep_year;
	 private Long population;
	 private int life_expectancy;
	 private double gnp;
	 private double gnp_old;
	 private String local_name;
	 
	 private String government_form;
	 private String head_of_state;
	 private long capital;
	 private String code2;
	 
	 @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
	 private List<City> cities;
	 
	 @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
	 private List<Language> languages;
	 
	 public Country() {}
	 
	 public Long getId() {
	        return id;
	    }    
	    public void setId(long id) {
	        this.id =  id;
	    }
	    
	    
	    
}
