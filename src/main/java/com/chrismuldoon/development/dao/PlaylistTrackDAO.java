package com.chrismuldoon.development.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.chrismuldoon.development.entities.PlaylistTrack;

@Local
public interface PlaylistTrackDAO {
	public void addPlaylistTracks(Collection<PlaylistTrack> playlistTracks);
	public Collection<PlaylistTrack> getAllPlaylistTracks();
}
