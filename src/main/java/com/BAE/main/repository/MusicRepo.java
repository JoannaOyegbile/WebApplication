package com.BAE.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BAE.main.entities.Music;

@Repository
public interface MusicRepo extends JpaRepository<Music, Long>{

	//SELECT * FROM music WHERE artist_name = ?1
	List<Music> findMusicByArtistName(String artistName);
		
	//SELECT * FROM music WHERE release_date= ?1
	List<Music> findMusicByReleaseDate(String releaseDate);
		
	//SELECT * FROM music WHERE genre =?1
	List<Music> findMusicByGenre(String genre);
}
