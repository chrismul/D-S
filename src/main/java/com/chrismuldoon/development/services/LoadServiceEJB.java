package com.chrismuldoon.development.services;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.chrismuldoon.development.dao.PlaylistDAO;
import com.chrismuldoon.development.dao.TrackDAO;
import com.chrismuldoon.development.entities.Track;



@Local
@Stateless
public class LoadServiceEJB implements LoadService{

	@Inject 
	TrackDAO dao;
	
	@Inject
	PlaylistDAO pdao;
	
	@Override
	public void LoadData() {
		XMLParser x = new XMLParser();
		
		x.parseXML();
		
		dao.addTracks(x.getAllTracks());
		pdao.addPlaylists(x.getAllPlaylists());
		
	}

	

}
