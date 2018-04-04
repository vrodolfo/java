package com.rodolfo.relationships.services;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.rodolfo.relationships.models.License;
import com.rodolfo.relationships.models.Person;
import com.rodolfo.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private PersonRepository personRepository;
	
	
	public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
	
	
	
	public List<Person> allPeople() {
	     return (List<Person>) personRepository.findAll();
	 }
	
	public void addPerson(Person person) {
		System.out.println("33Firstname: " + person.getFirstName());
   	 	System.out.println("33Laststname: " + person.getLastName());
   	 	
   	    System.out.println("pasooooooooo: " + person.getLastName());
		personRepository.save(person);
	 }
	
	public Person findPersonById(Long id) {
		 return personRepository.findById(id).orElse(null);
	}

}
