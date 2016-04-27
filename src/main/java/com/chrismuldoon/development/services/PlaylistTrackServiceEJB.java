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

import com.chrismuldoon.development.dao.PlaylistTrackDAO;
import com.chrismuldoon.development.entities.PlaylistTrack;

@Stateless
@Local
@TransactionAttribute (TransactionAttributeType.REQUIRED)
public class PlaylistTrackServiceEJB implements PlaylistTrackService{

	Logger logger = Logger.getLogger("PlaylistTrackEJB");
	
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private PlaylistTrackDAO dao;
	
	@Resource
	private SessionContext context;

	@PostConstruct
	public void init() {
		logger.info("in PlaylistTrackServiceEJB.init");
		logger.info(em.toString());
	}
	
	/**
	 * Sets the attached DAO to the EJB service
	 * @param dao new dao
	 */
	public void setDao(PlaylistTrackDAO dao) {
		this.dao = dao;
	}

	@Override
	public void addPlaylistTracks(Collection<PlaylistTrack> playlistTracks) {
		dao.addPlaylistTracks(playlistTracks);
	}

	@Override
	public Collection<PlaylistTrack> getAllPlaylistTracks() {
		// TODO Auto-generated method stub
		return dao.getAllPlaylistTracks();
	}
	
}