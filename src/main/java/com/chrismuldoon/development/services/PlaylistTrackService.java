package com.chrismuldoon.development.services;

import java.util.Collection;

import javax.ejb.Local;

import com.chrismuldoon.development.entities.Playlist;
import com.chrismuldoon.development.entities.PlaylistTrack;

@Local
public interface PlaylistTrackService {

	public void addPlaylistTracks(Collection<PlaylistTrack> playlistTracks);
	public Collection<PlaylistTrack> getAllPlaylistTracks();


}

