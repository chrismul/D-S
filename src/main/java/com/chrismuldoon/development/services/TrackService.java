package com.chrismuldoon.development.services;

import java.util.Collection;

import javax.ejb.Local;

import com.chrismuldoon.development.entities.Track;

@Local
public interface TrackService {
	public void addTrack(Track track);
	public Track getTrack(String trackName);
	public void updateTrack(Track Track);
	public Collection<Track> getTracksByArtist(String artistName);
	public Collection<Track> getTracksByGenre(String genre);
	
	public Collection<Track> getTracksByAlbum(String albumName);
	public Collection<Track> getAllTracks();
	
	
	public Collection<String> getAllGenres();
	public Collection<String> getAllArtists();
}
