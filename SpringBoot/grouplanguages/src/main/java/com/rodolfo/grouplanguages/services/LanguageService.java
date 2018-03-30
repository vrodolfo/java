package com.rodolfo.grouplanguages.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//...
import org.springframework.stereotype.Service;
import com.rodolfo.grouplanguages.models.Language;
@Service
public class LanguageService {
 
 // initialize the books variable with values
 private List<Language> languages = new ArrayList<Language>(Arrays.asList(
         new Language("Java", "Rodof", "1.0")
        
         ));
 
 // returns all the books
 public List<Language> allLanguages() {
     return languages;
 }
 
 public void addLanguage(Language language) {
	 languages.add(language);
 }
 
 public Language findLanguageByIndex(int index) {
     if (index < languages.size()){
         return languages.get(index);
     }else{
         return null;
     }
 }
 
 public void updateLanguage(int id, Language language) {
     if (id < languages.size()){
    	 languages.set(id, language);
     }
 }
 
 public void destroyLanguage(int id) {
     if (id < languages.size()){
    	 languages.remove(id);
     }
 }
}



