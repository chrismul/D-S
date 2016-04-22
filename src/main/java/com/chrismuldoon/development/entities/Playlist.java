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

@Entity @Table(name="playlists")
@XmlRootElement
public class Playlist implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id") private Integer id;
	
	@Column(name="playlist_name") private String playlistName;
	@Column(name="persistent_id") private String persistentId;
	
	
	
//	//Adding relationships
//	@OneToMany(mappedBy="playlist", cascade={CascadeType.ALL})
//	@JsonIgnore
//	private Set<Track> track = new HashSet<Track>();
//	//@XmlTransient
	
	public Playlist(Integer id, String playlistName, String persistentId) {
		this.id = id;
		this.playlistName = playlistName;
		this.persistentId = persistentId;
	}
		
	public Playlist() {}

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
	
	public String getPersistentId() {
		return persistentId;
	}

	public void setPersistentId(String persistentId) {
		this.persistentId = persistentId;
	}

	
//	@JsonIgnore
//	public Set<Track> getTrack() {
//		return track;
//	}
//
//	public void setTrack(Set<Track> track) {
//		this.track = track;
//	}

}
