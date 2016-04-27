package com.chrismuldoon.development.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlaylistTrackList implements Serializable{

	private static final long serialVersionUID = 1L;
	private Collection<PlaylistTrack> playlistTrackCollection;
	
	/**
	 * Retrieves all rows from UserTable
	 * @return Collection of UserTable rows
	 */
	public Collection<PlaylistTrack> getPlaylistTrackCollection() {
        return playlistTrackCollection;
    }
	
	/**
	 * Add a row to UsersTable
	 * @param Users object 
	 */
    public void setPlaylistTrackCollection(Collection<PlaylistTrack> playlistTrackCollection) {
        this.playlistTrackCollection = playlistTrackCollection;
    }
}
