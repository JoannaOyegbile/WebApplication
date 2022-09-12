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
@RequestMapping("/music")
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
}
