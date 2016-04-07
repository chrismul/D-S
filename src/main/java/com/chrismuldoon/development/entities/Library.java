package com.chrismuldoon.development.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity @Table(name="library")
@XmlRootElement
public class Library implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Id") private Integer id;
	
	@Column(name="PlaylistName") private String playlistName;
	
	@ManyToOne
	@JoinColumn(name="UserId", referencedColumnName = "Id")
	private User user;
	
	//Adding relationships
	@OneToMany(mappedBy="library", cascade={CascadeType.ALL})
	@JsonIgnore
	private Set<Playlist> playlist = new HashSet<Playlist>();
	//@XmlTransient

	public Library(Integer id, String playlistName, User user) {
		super();
		this.id = id;
		this.playlistName = playlistName;
		this.user = user;
	}

	public Library() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Playlist> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Set<Playlist> playlist) {
		this.playlist = playlist;
	}

}
