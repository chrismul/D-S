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

@Entity @Table(name="libraries")
@XmlRootElement
public class Library implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="libraryPersistentId") private String libraryPersistentId;
	
	@ManyToOne
	@JoinColumn(name="username", referencedColumnName = "username", updatable = false)
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
		
	public Library(String libraryPersistentId, User user) {
		super();
		this.libraryPersistentId = libraryPersistentId;
		this.user = user;
	}

	public Library() {}

	public String getLibraryPersistentId() {
		return libraryPersistentId;
	}

	public void setLibraryPersistentId(String libraryPersistentId) {
		this.libraryPersistentId = libraryPersistentId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
