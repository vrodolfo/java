package com.rodolfo.grouplanguagesreload.services;

import java.util.List;
import java.util.Optional;

//...
import org.springframework.stereotype.Service;
import com.rodolfo.grouplanguagesreload.models.Language;
import com.rodolfo.grouplanguagesreload.repositories.LanguageRepository;
@Service
public class LanguageService {
	
	private LanguageRepository languageRepository;
 
	
	public LanguageService(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }
 
 // returns all the languages
public List<Language> allLanguages() {
     return (List<Language>) languageRepository.findAll();
 }
 
 public void addLanguage(Language language) {
	 languageRepository.save(language);
 }
 
 public Language findLanguageById(Long id) {
	 //return languageRepository.findById(id);
	 return languageRepository.findById(id).orElse(null);
 }
 
 public void updateLanguage(Language language) {
	 System.out.println("IDDDDDDDDD:::::: " + language.getId());
	 languageRepository.save(language);
 }
 
 public void destroyLanguage(Long id) {
	 languageRepository.deleteById(id);
 }
}



