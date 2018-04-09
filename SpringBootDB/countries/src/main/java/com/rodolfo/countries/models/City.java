package com.rodolfo.countries.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rodolfo.countries.models.Country;

@Entity
@Table(name="cities")
public class City {
	@Id
    @GeneratedValue
    private Long id;
	
	private String name;
	private String country_code;
	private String district;
	private Long   population;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id")
    private Country country;
	
	public City() {}
	
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
    
    public String getCountry_code() {
        return country_code;
    }    
    public void setCountry_code(String country_code) {
        this.country_code =  country_code;
    }
    
    public String getDistrict() {
        return district;
    }    
    public void setDistrict(String district) {
        this.district =  district;
    }
    
    public Long getPopulation() {
        return population;
    }    
    public void setPopulation(long population) {
        this.population =  population;
    }
	
	 
}
