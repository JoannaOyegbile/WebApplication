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
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
}
