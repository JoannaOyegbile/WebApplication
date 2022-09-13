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
	public void createTest() throws Exception{
		
		Music input = new Music("Alessia Cara", "Scars to Your Beautiful", "Pop", "2015");
		String inputAsJSON = mapper.writeValueAsString(input);
		
		Music response = new Music(2L, "Alessia Cara", "Scars to Your Beautiful", "Pop", "2015");
		String responseAsJSON = mapper.writeValueAsString(response);
		
		mvc.perform(post("/project/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inputAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(responseAsJSON));
	}
	
	@Test
	public void getAllTest() throws Exception {
		List<Music> result = new ArrayList<>();
		result.add(new Music(1L, "Leona Lewis", "Bleeding Love", "R&B", "2007"));
		
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/project/getAll")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByIdTest() throws Exception {
		
		Music result = new Music(1L, "Leona Lewis", "Bleeding Love", "R&B", "2007");
		
		String resultAsJSON = mapper.writeValueAsString(result);
		
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
				
		mvc.perform(put("/project/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(inputAsJSON))
			.andExpect(status().isAccepted())
			.andExpect(content().json(responseAsJSON));
	}

	@Test
	public void deleteTest() throws Exception{
		mvc.perform(delete("/project/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("true"));
				
	}

}
