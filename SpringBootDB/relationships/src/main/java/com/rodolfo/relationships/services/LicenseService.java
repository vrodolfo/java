package com.rodolfo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.rodolfo.relationships.models.License;
import com.rodolfo.relationships.repositories.LicenseRepository;
import com.rodolfo.relationships.repositories.PersonRepository;

@Service
public class LicenseService {
	private LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository){
        this.licenseRepository = licenseRepository;
    }
	
	public List<License> allLicenses() {
	     return (List<License>) licenseRepository.findAll();
	 }
	
	public void addLicense(License license) {
		licenseRepository.save(license);
	 }
	
	public License findLicenseById(Long id) {
		 return licenseRepository.findById(id).orElse(null);
	}
	
	public String getNumber() {
		String lastID = Long.toString(licenseRepository.getLastId());
		
		return (lastID);
	}

}
