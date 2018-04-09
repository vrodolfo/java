package com.rodolfo.countries.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cities")
public class Language {
	@Id
    @GeneratedValue
    private Long id;
	
	private String language;
	private String country_code;
	private String is_official;
	private Long   percentage;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id")
    private Country country;
	
	public Language() {}
	
	public Long getId() {
        return id;
    }    
    public void setId(long id) {
        this.id =  id;
    }
}
