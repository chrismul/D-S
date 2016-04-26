package com.chrismuldoon.development.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlaylistList implements Serializable{

	private static final long serialVersionUID = 1L;
	private Collection<Playlist> playlistCollection;
	
	/**
	 * Retrieves all rows from UserTable
	 * @return Collection of UserTable rows
	 */
	public Collection<Playlist> getPlaylistCollection() {
        return playlistCollection;
    }
	
	/**
	 * Add a row to UsersTable
	 * @param Users object 
	 */
    public void setPlaylistCollection(Collection<Playlist> playlistCollection) {
        this.playlistCollection = playlistCollection;
    }
}
