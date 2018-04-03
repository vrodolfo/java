package com.rodolfo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.rodolfo.lookify.models.Song;
import com.rodolfo.lookify.repositories.SongRepository;
@Service
public class SongService {
	private SongRepository songRepository;
 
	
	public SongService(SongRepository songRepository){
        this.songRepository = songRepository;
    }
 
	
	 public List<Song> topTenM() {
		 
		// User findByOhterObj(OtherObj otherObj);
		// return (List<Song>) findTop10ByRating(int rating, Sort sort);
	     return (List<Song>) songRepository.topTen();
	 }
	 
	 public List<Song> findByDescription(String search){
		 return (List<Song>) songRepository.searchByArtist(search);
		 
	 }
	
	 // returns all the songs
	 public List<Song> allSongs() {
	     return (List<Song>) songRepository.findAll();
	 }
	 
	 public void addSong(Song song) {
		 songRepository.save(song);
	 }
	 
	 public Song findSongById(Long id) {
		 return songRepository.findById(id).orElse(null);
	 }
	 
	 public void updateSong(Song language) {
		 songRepository.save(language);
	 }
	 
	 public void destroySong(Long id) {
		 songRepository.deleteById(id);
	 }
	 

}
