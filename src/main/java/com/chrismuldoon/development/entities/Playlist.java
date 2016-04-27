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
	
	@ManyToOne
	@JoinColumn(name="library_persistent_id", referencedColumnName = "persistent_id", updatable = false)
	private Library library;
	
	@JsonIgnore
    @OneToMany(mappedBy="playlist", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private Set<PlaylistTrack> playlist_track = new HashSet<PlaylistTrack>();
	
	public Playlist(Integer id, String playlistName) {
		this.id = id;
		this.playlistName = playlistName;
	}
		
	public Playlist() {
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
	
	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public Set<PlaylistTrack> getPlaylist_track() {
		return playlist_track;
	}

	public void setPlaylist_track(Set<PlaylistTrack> playlist_track) {
		this.playlist_track = playlist_track;
	}
	
}
