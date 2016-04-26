package com.chrismuldoon.development.services;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.chrismuldoon.development.dao.LibraryDAO;
import com.chrismuldoon.development.dao.PlaylistDAO;
import com.chrismuldoon.development.dao.TrackDAO;
import com.chrismuldoon.development.entities.Playlist;
import com.chrismuldoon.development.entities.Track;



@Local
@Stateless
public class LoadServiceEJB implements LoadService{

	@Inject 
	TrackDAO dao;
	
	@Inject
	PlaylistDAO pdao;
	
	@Inject
	LibraryDAO ldao;
	
	@Override
	public void LoadData() {
		XMLParser x = new XMLParser();
		
		x.parseXML();
	//	ldao.addLibrary(x.getLibrary());
		System.out.println(x.getLibrary().getId());
	//	pdao.addPlaylists(x.getAllPlaylists());
		for(Playlist p: x.getAllPlaylists()){
			System.out.println(p.getPlaylistName());
		}
		dao.addTracks(x.getAllTracks());
	}

	

}
