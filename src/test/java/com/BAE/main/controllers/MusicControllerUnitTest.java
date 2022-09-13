package com.BAE.main.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
}
