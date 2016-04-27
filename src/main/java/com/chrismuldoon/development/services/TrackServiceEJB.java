package com.chrismuldoon.development.services;

import java.util.Collection;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.chrismuldoon.development.dao.TrackDAO;
import com.chrismuldoon.development.entities.Track;

@Stateless
@Local
@TransactionAttribute (TransactionAttributeType.REQUIRED)
public class TrackServiceEJB implements TrackService {

Logger logger = Logger.getLogger("TrackEJB");
	
	@PersistenceContext
	private EntityManager em;
		
	@Inject
	private TrackDAO dao;
	
	@Resource
	private SessionContext context;

	@PostConstruct
	public void init() {
		logger.info("in TrackServiceEJB.init");
		logger.info(em.toString());
	}
	
	/**
	 * Sets the attached DAO to the EJB service
	 * @param dao new dao
	 */
	public void setDao(TrackDAO dao) {
		this.dao = dao;
	}

	@Override
	public void addTrack(Track track) {
		dao.addTrack(track);
	}

	@Override
	public Track getTrack(String trackName) {
		return dao.getTrack(trackName);
	}

	@Override
	public void updateTrack(Track track) {
		dao.updateTrack(track);
	}

	@Override
	public Collection<Track> getTracksByArtist(String artistName) {
		return dao.getTracksByArtist(artistName);
	}

	@Override
	public Collection<Track> getTracksByAlbum(String albumName) {
		return dao.getTracksByAlbum(albumName);
	}

	@Override
	public Collection<Track> getAllTracks() {
		return dao.getAllTracks();
	}

}
