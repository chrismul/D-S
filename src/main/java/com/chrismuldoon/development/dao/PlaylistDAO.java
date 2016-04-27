package com.chrismuldoon.development.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.chrismuldoon.development.entities.Playlist;

@Local
public interface PlaylistDAO {
	public void addPlaylists(Collection<Playlist> playlists);
	public Collection<Playlist> getAllPlaylists();
}
