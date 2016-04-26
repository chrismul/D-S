package com.chrismuldoon.development.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.chrismuldoon.development.entities.Library;
import com.chrismuldoon.development.entities.Playlist;
import com.chrismuldoon.development.entities.Track;


@Local
public interface PlaylistDAO {
	public void addPlaylists(Collection<Playlist> playlists);
	public Collection<Playlist> getAllPlaylists();
}
