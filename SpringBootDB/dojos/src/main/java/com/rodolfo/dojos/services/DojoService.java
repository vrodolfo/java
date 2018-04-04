package com.rodolfo.dojos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rodolfo.dojos.models.Dojo;
import com.rodolfo.dojos.repositories.DojoRepository;

	@Service
	public class DojoService {
		private DojoRepository dojoRepository;
		
		
		public DojoService(DojoRepository dojoRepository){
	        this.dojoRepository = dojoRepository;
	    }
		
		
		
		public List<Dojo> allDojos() {
		     return (List<Dojo>) dojoRepository.findAll();
		 }
		
		public void addDojo(Dojo dojo) {
			dojoRepository.save(dojo);
		 }
		
		public Dojo findDojoById(Long id) {
			 //System.out.println("id:::::::::::::::::" + id);
			 return dojoRepository.findById(id).orElse(null);
		}
}
