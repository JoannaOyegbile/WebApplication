package com.BAE.main.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.BAE.main.entities.Music;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class MusicControllerIntergrationTest {
	
	@Autowired
	private MockMvc mvc; 
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createTest(){
		
	}
	
	@Test
	public void getAllTest() throws Exception {
		List<Music> result = new ArrayList<>();
		result.add(new Music(1L, "The Greatest Showman", "This is me", "Musical", "2017"));
		
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/project/getAll")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByIdTest() throws Exception {
		
		Music result = new Music(1L, "The Greatest Showman", "This is me", "Musical", "2017");
		
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/music/getById/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isFound())
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByArtistNameTest() throws Exception{
		List<Music> result = new ArrayList<>();
		result.add(new Music(1L, "The Greatest Showman", "This is me", "Musical", "2017"));
		
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/music/getByArtistName/The Greatest Showman")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByReleaseDateTest() throws Exception{
		List<Music> result = new ArrayList<>();
		result.add(new Music(1L, "The Greatest Showman", "This is me", "Musical", "2017"));
		
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/music/getByReleaseDate/2017")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(resultAsJSON));
	}

}
