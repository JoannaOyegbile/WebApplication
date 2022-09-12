package com.BAE.main.entities;



import java.util.Objects;

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
	
	public Music(long id, String artistName, String songName, String genre, String releaseDate) {
		super();
		this.id = id;
		this.artistName = artistName;
		this.songName = songName;
		this.genre = genre;
		this.releaseDate = releaseDate;
	}
	
	
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
	
	@Override
	public int hashCode() {
		return Objects.hash(artistName, genre, id, releaseDate, songName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Music other = (Music) obj;
		return Objects.equals(artistName, other.artistName) && Objects.equals(genre, other.genre) && id == other.id
				&& Objects.equals(releaseDate, other.releaseDate) && Objects.equals(songName, other.songName);
	}
}
