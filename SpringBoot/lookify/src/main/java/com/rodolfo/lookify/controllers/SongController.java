package com.rodolfo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rodolfo.lookify.models.Song;
import com.rodolfo.lookify.services.SongService;

@Controller
public class SongController {

	 private final SongService songService;
	 public SongController(SongService songService){
	     this.songService = songService;
	 }
	 
	 @RequestMapping("/")
	 public String index() {
		 System.out.println("indexxxxxxxx");
	     return "index.jsp";
	 }
	 
	 @RequestMapping("/dashboard")
	 public String dashboard(Model model, @ModelAttribute("song") Song song) {
	     List<Song> songs = songService.allSongs();
	     model.addAttribute("songs", songs);
	     return "songs.jsp";
	 }
	 
	 @RequestMapping("/songs/{id}")
	 public String findSongById(Model model, @PathVariable("id") long id) {
		 model.addAttribute("song", songService.findSongById(id));
	     return "showSong.jsp";
	 }
	 
	 @RequestMapping("/songs/new")
	 public String newSong(@ModelAttribute("song") Song song) {
	     return "newSong.jsp";
	 }
	 
	 @RequestMapping("/topten")
	 public String topten(Model model, @ModelAttribute("song") Song song) {
		 List<Song> songs = songService.topTenM();
	     model.addAttribute("songs", songs);
	     return "topten.jsp";
	 }
	 
	// @RequestMapping("/search/{search}")
	 @RequestMapping( path="/search", method=RequestMethod.GET)
	 //public String search(Model model, @PathVariable("search") String search) {
	 public String search(Model model,  @RequestParam(value="search", required=false) String search) {
		 List<Song> songs = songService.findByDescription(search);
	     model.addAttribute("songs", songs);
	     model.addAttribute("artist", search);
	     return "search.jsp";
	 }
	
	 
	 @PostMapping("/songs/new")
	 public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
	     if (result.hasErrors()) {
	         return "newSong.jsp";
	     }else{
	         songService.addSong(song);
	         return "redirect:/dashboard";
	     }
	 }
	 
	 @RequestMapping(value="/songs/delete/{id}")
	 public String destroySongs(@PathVariable("id") Long id) {
	     songService.destroySong(id);
	     return "redirect:/dashboard";
	 }
	 
}
