package com.chrismuldoon.development.dao;

import java.util.Collection;
import javax.ejb.Local;
import com.chrismuldoon.development.entities.Track;

@Local
public interface TrackDAO {
	public void addTrack(Track track);
	public void addTracks(Collection<Track> tracks);
	public Track getTrack(String trackName);
	public void updateTrack(Track track);
	public Collection<Track> getTracksByArtist(String artistName);
	public Collection<Track> getTracksByAlbum(String albumName);
	public Collection<Track> getAllTracks();
}

