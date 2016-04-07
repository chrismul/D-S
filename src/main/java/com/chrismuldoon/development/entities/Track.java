package com.chrismuldoon.development.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity @Table(name="track")
public class Track implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id") private Integer id;
	
	@Column(name="Title") private String title; 
	@Column(name="Artist") private String artist; 
	@Column(name="Album") private String album; 
	@Column(name="Genre") private String genre; 
	@Column(name="Year") private String year;
	@Column(name="Length") private String length; 
	@Column(name="Size") private String size;
	@Column(name="DateAdded") private String dateAdded;
	@Column(name="Location") private String location;
	
	@ManyToOne
	@JoinColumn(name="PlaylistId", referencedColumnName = "Id")
	private Playlist playlist;

	public Track(Integer id, String title, String artist, String album,
			String genre, String year, String length, String size,
			String dateAdded, String location, Playlist playlist) {
			this.id = id;
			this.title = title;
			this.artist = artist;
			this.album = album;
			this.genre = genre;
			this.year = year;
			this.length = length;
			this.size = size;
			this.dateAdded = dateAdded;
			this.location = location;
			this.playlist = playlist;
	}
	
	public Track(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
}

	