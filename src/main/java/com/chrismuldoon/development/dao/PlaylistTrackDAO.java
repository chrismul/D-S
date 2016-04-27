package com.chrismuldoon.development.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.chrismuldoon.development.entities.Library;
import com.chrismuldoon.development.entities.Playlist;
import com.chrismuldoon.development.entities.PlaylistTrack;
import com.chrismuldoon.development.entities.Track;


@Local
public interface PlaylistTrackDAO {
	public void addPlaylistTracks(Collection<PlaylistTrack> playlistTracks);
	public Collection<PlaylistTrack> getAllPlaylistTracks();
}
