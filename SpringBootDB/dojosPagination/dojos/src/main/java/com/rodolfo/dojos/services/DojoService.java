package com.rodolfo.dojos.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rodolfo.dojos.models.Dojo;
import com.rodolfo.dojos.models.Ninja;
import com.rodolfo.dojos.repositories.DojoRepository;
import com.rodolfo.dojos.repositories.NinjaRepository;

	@Service
	@Transactional
	public class DojoService {
		@Autowired 
		private DojoRepository dojoRepository;
		//private DojoRepository ninjaRepository;
		
		// static variable to set the number of ninjas that we want per page
	    private static final int PAGE_SIZE = 5;
		
		
		public DojoService(DojoRepository dojoRepository){
	        this.dojoRepository = dojoRepository;
	    }
		
		public Page<Object> dojosPerPage(int pageNumber) {
	        // get all the ninjas page and sort them in ascending order the last name property
	        PageRequest pageRequest = new PageRequest(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "name");
	        Page<Object> dojos = dojoRepository.allDojos(pageRequest);
	        return dojoRepository.allDojos(pageRequest);
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
