package com.BAE.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.BAE.main.repository.MusicRepo;

@SpringBootTest
public class MusicServiceUnitTest {
	
	@Autowired
	private MusicService service;
	
	@MockBean
	private MusicRepo repo;
	
	

}
