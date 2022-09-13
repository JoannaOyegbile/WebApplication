package com.BAE.main.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.BAE.main.entities.Music;
import com.BAE.main.repository.MusicRepo;

@SpringBootTest
public class MusicServiceUnitTest {
	
	@Autowired
	private MusicService service;
	
	@MockBean
	private MusicRepo repo;
	
	@Test
	public void createTest() {
		
		Music input = new Music("Alessia Cara", "Scars to Your Beautiful", "Pop", "2015");
		
	}

}
