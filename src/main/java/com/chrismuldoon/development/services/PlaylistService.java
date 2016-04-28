package com.chrismuldoon.development.services;

import java.util.Collection;

import javax.ejb.Local;

import com.chrismuldoon.development.entities.Playlist;

@Local
public interface PlaylistService {
	public void addPlaylists(Collection<Playlist> playlists);
	public Collection<Playlist> getAllPlaylists();
	public Collection<Playlist> getAllPlaylistsInLibrary(String libraryPersistentId);
	public Collection<String> getPlaylistsNames();}

