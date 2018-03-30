package com.rodolfo.grouplanguages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//..
import com.rodolfo.grouplanguages.models.Language;
import com.rodolfo.grouplanguages.services.LanguageService;
@Controller
public class Languages {
 
 private final LanguageService languageService;
 public Languages(LanguageService languageService){
     this.languageService = languageService;
 }
 @RequestMapping("/languages")
 public String languages(Model model, @ModelAttribute("language") Language language) {
     List<Language> languages = languageService.allLanguages();
     model.addAttribute("languages", languages);
     return "languages.jsp";
 }
 
 @RequestMapping("/languages/{index}")
 public String findLanguageByIndex(Model model, @PathVariable("index") int index) {
     Language language = languageService.findLanguageByIndex(index);
     model.addAttribute("language", language);
     model.addAttribute("id", index);
     return "showLanguage.jsp";
 }
 
 @RequestMapping("/languages/new")
 public String newLanguage(@ModelAttribute("language") Language language) {
     return "newBook.jsp";
 }
 
 @PostMapping("/languages/new")
 public String createBook(@Valid @ModelAttribute("language") Language language, BindingResult result) {
     if (result.hasErrors()) {
         return "languages.jsp";
     }else{
         languageService.addLanguage(language);
         return "redirect:/languages";
     }
 }
 
 @RequestMapping("/languages/edit/{id}")
 public String editLanguage(@PathVariable("id") int id, Model model) {
	 Language language = languageService.findLanguageByIndex(id);
     if (language != null){
         model.addAttribute("language", language);
         return "editLanguage.jsp";
     }else{
         return "redirect:/languages";
     }
 }
 
 @PostMapping("/languages/edit/{id}")
 public String updateLanguage(@PathVariable("id") int id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
     if (result.hasErrors()) {
         return "editLanguage.jsp";
     }else{
    	 languageService.updateLanguage(id, language);
         return "redirect:/languages";
     }
 }
 
 @RequestMapping(value="/languages/delete/{id}")
 public String destroyLanguage(@PathVariable("id") int id) {
     languageService.destroyLanguage(id);
     return "redirect:/languages";
 }
}

