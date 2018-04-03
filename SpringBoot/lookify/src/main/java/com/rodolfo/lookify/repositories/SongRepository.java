package com.rodolfo.lookify.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.rodolfo.lookify.models.Song;

@Repository
public interface SongRepository  extends CrudRepository<Song, Long> {
	
	@Query(value="SELECT * FROM song ORDER BY rating DESC LIMIT 10", nativeQuery = true)
	List<Song> topTen();
	
	List<Song> findAll();    
	
	@Query(value="SELECT * FROM song WHERE artist= :artist ORDER BY rating DESC LIMIT 10", nativeQuery = true)
	List<Song> searchByArtist(@Param("artist") String artist);
	
    Long countByTitleContaining(String search);
}
