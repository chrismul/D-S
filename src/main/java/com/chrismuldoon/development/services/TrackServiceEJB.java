package com.chrismuldoon.development.services;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jws.WebService;

import com.chrismuldoon.development.dao.TrackDAO;
import com.chrismuldoon.development.entities.Track;

@Stateless
@Local
@TransactionAttribute (TransactionAttributeType.REQUIRED)
public class TrackServiceEJB implements TrackService {

	private TrackDAO dao;
	
	public void setDao(TrackDAO dao) {
		this.dao = dao;
	}
	
	public Collection<Track> getCatalog() {
		return dao.getAllTracks();
	}

	public void addToCatalog(Track track) {
		dao.addTrack(track);
		
	}

}
