package com.chrismuldoon.development.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@ManyToOne
	@JoinColumn(name="library_persistent_id", referencedColumnName = "persistent_id", nullable = false, insertable = false, updatable = false)
	private Library library;
	
	@ManyToMany(fetch= FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="playlist_track", joinColumns= {@JoinColumn(name="track_id", nullable=false)}, 
									  inverseJoinColumns={@JoinColumn(name="playlist_id", nullable=false)})
	private Collection<Track> tracks;
	
	
	public Playlist(Integer id, String playlistName) {
		this.id = id;
		this.playlistName = playlistName;
		tracks = new ArrayList<Track>();
	}
		
	public Playlist() {
		tracks = new ArrayList<Track>();
	}

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
	
	public Collection<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Collection<Track> tracks) {
		this.tracks = tracks;
	}

}
