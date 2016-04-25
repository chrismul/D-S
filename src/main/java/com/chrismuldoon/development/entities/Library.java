package com.chrismuldoon.development.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;


@Entity @Table(name="libraries")
@XmlRootElement
public class Library implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="persistent_id") private String id;
	
	@ManyToOne
	@JoinColumn(name="username", referencedColumnName = "username", nullable = false, insertable = false, updatable = false)
	private User user;
	
	@JsonIgnore
    @OneToMany(mappedBy="library", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Playlist> playlists = new HashSet<Playlist>();

    public Set<Playlist> getPlaylists() {
                    return playlists;
    }

    public void setPlaylists(Set<Playlist> playlists) {
                    this.playlists = playlists;
    }
		
	public Library(String id, User user) {
		super();
		this.id = id;
		this.user = user;
	}

	public Library() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public Set<Playlist> getPlaylist() {
//		return playlist;
//	}
//
//	public void setPlaylist(Set<Playlist> playlist) {
//		this.playlist = playlist;
//	}

}
