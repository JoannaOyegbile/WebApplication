package com.BAE.main.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.BAE.main.entities.Music;
import com.BAE.main.services.MusicService;

@RestController
@RequestMapping("/project")
public class MusicController {
	
	private MusicService service;
	
	public MusicController(MusicService service) {
		super();
		this.service = service;
	}

	// Post request (CREATE)
	@PostMapping("/create")
	public ResponseEntity<Music> create(@RequestBody Music input) {
		return new ResponseEntity<Music> (service.create(input), HttpStatus.CREATED);
	} 

	// Get requests (READ)
	@GetMapping("/getAll")
	public List<Music> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Music> getById(@PathVariable long id) {
		return new ResponseEntity<Music> (service.getById(id), HttpStatus.FOUND);
	}
	
	@GetMapping("/getByArtistName/{artistName}")
	public List<Music> getByArtistName(@PathVariable String artistName) {
		return service.getByArtistName(artistName);
	}
	
	@GetMapping("/getByReleaseDate/{releaseDate}")
	public List<Music> getByReleaseDate(@PathVariable String releaseDate) {
		return service.getByReleaseDate(releaseDate);
	}
	
	@GetMapping("/getByGenre/{genre}")
	public List<Music> getByGenre(@PathVariable String genre) {
		return service.getByGenre(genre);
	}
	
	@GetMapping("/getBySongName/{songName}")
	public List<Music> getBySongName(@PathVariable String songName) {
		return service.getBySongName(songName);
	}
	
	// Put request (UPDATE)
	@PutMapping("/update/{id}")
	public ResponseEntity<Music> update(@PathVariable("id") long id, @RequestBody Music input) {
		return new ResponseEntity<Music> (service.update(id, input), HttpStatus.ACCEPTED);
	}
	
	// Delete request (DELETE)
	@DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable long id) {
        return service.delete(id);
    }

}




