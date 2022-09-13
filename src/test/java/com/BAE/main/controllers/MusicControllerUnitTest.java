package com.BAE.main.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.BAE.main.entities.Music;
import com.BAE.main.services.MusicService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class MusicControllerUnitTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper; 
	
	@MockBean
	private MusicService service;
	
	@Test
	public void createTest() throws Exception{
	
		Music input = new Music("Alessia Cara", "Scars to Your Beautiful", "Pop", "2015");
		String inputAsJSON = mapper.writeValueAsString(input);
		
		Music response = new Music(2L, "Alessia Cara", "Scars to Your Beautiful", "Pop", "2015");
		String responseAsJSON = mapper.writeValueAsString(response);
		
		Mockito.when(service.create(input)).thenReturn(response);
		
		mvc.perform(post("/project/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inputAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(responseAsJSON));
	}
	
	@Test
	public void gellAllTest() throws Exception {
		List<Music> result = new ArrayList<>();
		result.add(new Music(1L, "Leona Lewis", "Bleeding Love", "R&B", "2007"));
		
		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.getAll()).thenReturn(result);
		
		mvc.perform(get("/project/getAll")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByIdTest() throws Exception {
		
		Music result = new Music(1L, "Leona Lewis", "Bleeding Love", "R&B", "2007");
		
		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.getById(1L)).thenReturn(result);
		
		mvc.perform(get("/project/getById/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isFound())
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByArtistNameTest() throws Exception{
		List<Music> result = new ArrayList<>();
		result.add(new Music(1L, "Leona Lewis", "Bleeding Love", "R&B", "2007"));
		
		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.getByArtistName("Leona Lewis")).thenReturn(result); 
		
		mvc.perform(get("/project/getByArtistName/Leona Lewis")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByReleaseDateTest() throws Exception{
		List<Music> result = new ArrayList<>();
		result.add(new Music(1L, "Leona Lewis", "Bleeding Love", "R&B", "2007"));
		
		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.getByReleaseDate("2007")).thenReturn(result);
		
		mvc.perform(get("/project/getByReleaseDate/2007")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByGenreTest() throws Exception{
		List<Music> result = new ArrayList<>();
		result.add(new Music(1L, "Leona Lewis", "Bleeding Love", "R&B", "2007"));
		
		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.getByGenre("R&B")).thenReturn(result);
		
		mvc.perform(get("/project/getByGenre/R&B")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getBySongNameTest() throws Exception{
		List<Music> result = new ArrayList<>();
		result.add(new Music(1L, "Leona Lewis", "Bleeding Love", "R&B", "2007"));
		
		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.getByGenre("Bleeding Love")).thenReturn(result);
		
		mvc.perform(get("/project/getBySongName/Bleeding Love")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(resultAsJSON));
	}
	
	
	@Test
	public void updateTest() throws Exception{
		
		Music input = new Music(1L,"The Greatest Showman", "Rewrite the Stars", "Musical", "2017");
		String inputAsJSON = mapper.writeValueAsString(input);
				
		Music response = new Music(1L, "The Greatest Showman", "Rewrite the Stars", "Musical", "2017");
		String responseAsJSON = mapper.writeValueAsString(response);
				
		Mockito.when(service.update(1L, input)).thenReturn(response);
				
		mvc.perform(put("/project/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(inputAsJSON))
			.andExpect(status().isAccepted())
			.andExpect(content().json(responseAsJSON));
	}
	
	@Test
	public void deleteTest() throws Exception{
		
		Mockito.when(service.delete(1L)).thenReturn(true);
		
		mvc.perform(delete("/project/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("true"));
				
	}
	
	@Test
	public void deleteFailTest() throws Exception{
		
		Mockito.when(service.delete(1L)).thenReturn(false);
		
		mvc.perform(delete("/project/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("false"));
				
	}
	
}
