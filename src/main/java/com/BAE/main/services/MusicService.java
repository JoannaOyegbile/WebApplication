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

}
