package com.BAE.main.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.BAE.main.entities.Music;
import com.BAE.main.exceptions.MusicNotFoundException;
import com.BAE.main.repository.MusicRepo;

@Service
public class MusicService {

	private MusicRepo repo;
	
	public MusicService(MusicRepo repo) {
		super();
		this.repo = repo;
	}
	
		public Music create(Music input) {
			return repo.saveAndFlush(input);
		}
		public List<Music> getAll(){
			return repo.findAll();
		}
		
		public Music getById(long id) {
			return repo.findById(id).orElseThrow(MusicNotFoundException::new);
		}
		
		public List<Music> getByArtistName(String artistName) {
			return repo.findMusicByArtistName(artistName);
		}
		
		public List<Music> getByReleaseDate(String releaseDate) {
			return repo.findMusicByReleaseDate(releaseDate);
		}
		
		public List<Music> getByGenre(String genre) {
			return repo.findMusicByGenre(genre);
		}
		
		public List<Music> getBySongName(String songName) {
			return repo.findMusicBySongName(songName);
		}
		
		public Music update(long id, Music input) {
			Music existing = repo.findById(id).orElseThrow(MusicNotFoundException::new);

			existing.setArtistName(input.getArtistName());
			existing.setSongName(input.getSongName());
			existing.setGenre(input.getGenre());
			existing.setReleaseDate(input.getReleaseDate());
			
			return repo.saveAndFlush(existing);
		}
		
	    public boolean delete(long id) {
	    
	    	repo.deleteById(id);
	    	
	    	return !repo.existsById(id);
	    }

}
