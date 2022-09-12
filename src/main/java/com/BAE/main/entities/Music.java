package com.BAE.main.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Music {
	
    
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
		
	@Column(nullable = false)
	private String artistName; 
	
	@Column(nullable = false)
	private String songName; 
	
	@Column(nullable = false)
	private String genre; 
	
    
	@Column(nullable = false)
	private String releaseDate; 
}
