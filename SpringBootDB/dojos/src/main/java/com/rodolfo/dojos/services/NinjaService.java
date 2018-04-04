package com.rodolfo.dojos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rodolfo.dojos.models.Ninja;
import com.rodolfo.dojos.repositories.NinjaRepository;

@Service
public class NinjaService {
	private NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
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
