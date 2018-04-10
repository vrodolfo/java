package com.rodolfo.dojos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rodolfo.dojos.models.Ninja;
import com.rodolfo.dojos.repositories.NinjaRepository;

@Service
@Transactional
public class NinjaService {
	@Autowired 
	private NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
    }
	
	// static variable to set the number of ninjas that we want per page
    private static final int PAGE_SIZE = 5;
    public Page<Ninja> ninjasPerPage(int pageNumber) {
        // get all the ninjas page and sort them in ascending order the last name property
        PageRequest pageRequest = new PageRequest(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "lastName");
        Page<Ninja> ninjas = ninjaRepository.findAll(pageRequest);
        return ninjaRepository.findAll(pageRequest);
    }
	
	public List<Ninja> allNinjas() {
	     return (List<Ninja>) ninjaRepository.findAll();
	}
	
	public void addNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	 }
	
	public Ninja findNinjaById(Long id) {
		 return ninjaRepository.findById(id).orElse(null);
	}
	

}
