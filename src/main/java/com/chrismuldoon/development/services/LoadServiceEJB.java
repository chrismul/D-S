package com.chrismuldoon.development.services;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.chrismuldoon.development.dao.LibraryDAO;
import com.chrismuldoon.development.dao.PlaylistDAO;
import com.chrismuldoon.development.dao.PlaylistTrackDAO;
import com.chrismuldoon.development.dao.TrackDAO;

@Local
@Stateless
public class LoadServiceEJB implements LoadService{

	@Inject 
	TrackDAO dao;
	
	@Inject
	PlaylistDAO pdao;
	
	@Inject
	LibraryDAO ldao;
	
	@Inject
	PlaylistTrackDAO pldao;
	
	@Override
	public void LoadData(String filename) {
		XMLParser x = new XMLParser();
		
		x.parseXML(filename);
		
		ldao.addLibrary(x.getLibrary());
		
		pdao.addPlaylists(x.getAllPlaylists());
		
		dao.addTracks(x.getAllTracks());
		
		pldao.addPlaylistTracks(x.getAllPlaylistTracks());
		
	}
}
