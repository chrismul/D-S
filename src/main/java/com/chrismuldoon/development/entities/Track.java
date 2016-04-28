package com.chrismuldoon.development.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity 
@Table(name="tracks")
public class Track implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="trackId") private Integer trackId;
	
	@Column(name="name") private String name; 
	@Column(name="artist") private String artist; 
	@Column(name="album") private String album; 
	@Column(name="genre") private String genre; 
	@Column(name="year") private String year;
	@Column(name="location") private String location;
	
	
	@JsonIgnore
    @OneToMany(mappedBy="track", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private Set<PlaylistTrack> playlist_track = new HashSet<PlaylistTrack>();
	
	public Track(Integer trackId, String name, String artist, String album,
			String genre, String year, String location) {
		this.trackId = trackId;
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.genre = genre;
		this.year = year;
		this.location = location;
	}
	
	public Track() {}

	public Integer getTrackId() {
		return trackId;
	}

	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
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
	