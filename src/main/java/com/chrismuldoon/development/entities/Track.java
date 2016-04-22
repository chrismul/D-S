package com.chrismuldoon.development.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity 
@Table(name="tracks")
public class Track implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="track_id") private Integer id;
	
	@Column(name="name") private String name; 
	@Column(name="artist") private String artist; 
	@Column(name="album") private String album; 
	@Column(name="genre") private String genre; 
	@Column(name="year") private String year;
	@Column(name="location") private String location;
	
	public Track(Integer id, String name, String artist, String album,
			String genre, String year, String location) {
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.genre = genre;
		this.year = year;
		this.location = location;
	}
	
	public Track() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
	