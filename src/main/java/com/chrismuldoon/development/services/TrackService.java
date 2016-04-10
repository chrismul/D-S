package com.chrismuldoon.development.services;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.jws.WebService;

import com.chrismuldoon.development.entities.Track;

@Local
public interface TrackService {

	public Collection<Track> getCatalog() ;
	public void addToCatalog(Track disc);
	
}
