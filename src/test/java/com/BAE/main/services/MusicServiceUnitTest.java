package com.BAE.main.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.BAE.main.entities.Music;
import com.BAE.main.exceptions.MusicNotFoundException;
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
	
	@Test
	public void getByIdTest() throws Exception {
		Optional<Music> OptionalOutput = Optional.of(new Music(1L, "Leona Lewis", "Bleeding Love", "R&B", "2007"));
		Music output = new Music(1L, "Leona Lewis", "Bleeding Love", "R&B", "2007");
		
		Mockito.when(repo.findById(1L)).thenReturn(OptionalOutput);
		assertEquals(output, service.getById(1L));
		
	}
	
	@Test
	public void getByIdFailTest() throws Exception {
		Optional<Music> OptionalOutput = Optional.empty();
		
		Mockito.when(repo.findById(1L)).thenReturn(OptionalOutput);
		assertThrows(MusicNotFoundException.class, () -> service.getById(1L));
		
	}
	
	@Test
	public void getByArtistNameTest() throws Exception{
		List<Music> result = new ArrayList<>();
		result.add(new Music(1L, "Leona Lewis", "Bleeding Love", "R&B", "2007"));
		
		Mockito.when(repo.findMusicByArtistName("Leona Lewis")).thenReturn(result);
		assertEquals(result, service.getByArtistName("Leona Lewis"));
		
	}
	
	@Test
	public void getByReleaseDateTest() throws Exception{
		List<Music> result = new ArrayList<>();
		result.add(new Music(1L, "Leona Lewis", "Bleeding Love", "R&B", "2007"));

		Mockito.when(repo.findMusicByReleaseDate("2007")).thenReturn(result);
		assertEquals(result, service.getByReleaseDate("2007"));
	}
	
	@Test
	public void getByGenre() throws Exception{
		List<Music> result = new ArrayList<>();
		result.add(new Music(1L, "Leona Lewis", "Bleeding Love", "R&B", "2007"));

		Mockito.when(repo.findMusicByGenre("R&B")).thenReturn(result);
		assertEquals(result, service.getByGenre("R&B"));
	}
	
	@Test
	public void getBySongName() throws Exception{
		List<Music> result = new ArrayList<>();
		result.add(new Music(1L, "Leona Lewis", "Bleeding Love", "R&B", "2007"));

		Mockito.when(repo.findMusicBySongName("Bleeding Love")).thenReturn(result);
		assertEquals(result, service.getBySongName("Bleeding Love"));
	} 
	
	@Test
	public void updateTest() throws Exception{
		
		Music input = new Music("The Greatest Showman", "Rewrite the Stars", "Musical", "2017");
		Optional<Music> existing = Optional.of(new Music(1L, "Leona Lewis", "Bleeding Love", "R&B", "2007"));
		Music response = new Music(1L, "The Greatest Showman", "Rewrite the Stars", "Musical", "2017");
		
				
		Mockito.when(repo.findById(1L)).thenReturn(existing);
		Mockito.when(repo.saveAndFlush(response)).thenReturn(response);
				
		assertEquals(response,service.update(1L, input));
	}
	
	@Test
	public void deleteTrueTest() throws Exception{
		Mockito.when(repo.existsById(1L)).thenReturn(false);
		assertTrue(service.delete(1L));
	}
	
	@Test
	public void deleteFalseTest() throws Exception{
		
		Mockito.when(repo.existsById(1L)).thenReturn(true);
		assertFalse(service.delete(1L));
				
	}
	
}
