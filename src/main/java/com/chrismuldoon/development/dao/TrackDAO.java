package com.chrismuldoon.development.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.chrismuldoon.development.entities.Track;

@Local
public interface TrackDAO {
	
	void addTrack(Track track);
	Track getTrackByTitle(String title);
	Collection<Track> getTracksByArtist(String artist);
	Collection<Track> getAllTracks();
}


