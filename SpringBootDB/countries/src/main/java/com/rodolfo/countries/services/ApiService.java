package com.rodolfo.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rodolfo.countries.repositories.ApiRepository;

@Service
public class ApiService {
	private ApiRepository apiRepository;
	
	
	public ApiService(ApiRepository apiRepository){
        this.apiRepository = apiRepository;
    }
	
	public List<Object[]> query1() {
		 return apiRepository.query1();
	}
	
	public List<Object[]> query2() {
		 return apiRepository.query2();
	}
	
	public List<Object[]> query3() {
		 return apiRepository.query3();
	}
	
	public List<Object[]> query4() {
		 return apiRepository.query4();
	}
	
	public List<Object[]> query5() {
		 return apiRepository.query5();
	}
	
	public List<Object[]> query6() {
		 return apiRepository.query6();
	}
	
	public List<Object[]> query7() {
		 return apiRepository.query7();
	}
	
	public List<Object[]> query8() {
		 return apiRepository.query8();
	}
}
