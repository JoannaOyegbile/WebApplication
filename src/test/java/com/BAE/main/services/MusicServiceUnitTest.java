package com.BAE.main.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
		Music result = new Music(2L,"Alessia Cara", "Scars to Your Beautiful", "Pop", "2015");
		
		Mockito.when(repo.saveAndFlush(input)).thenReturn(result);
		assertEquals(result, service.create(input));
		
	}
	
	@Test
	public void gellAllTest() throws Exception {
		List<Music> result = new ArrayList<>();
		result.add(new Music(1L, "Leona Lewis", "Bleeding Love", "R&B", "2007"));
		
		Mockito.when(repo.findAll()).thenReturn(result);
		assertEquals(result, service.getAll());
		
	}

}
