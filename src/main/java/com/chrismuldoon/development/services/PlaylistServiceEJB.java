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

import com.chrismuldoon.development.dao.PlaylistDAO;
import com.chrismuldoon.development.entities.Playlist;

@Stateless
@Local
@TransactionAttribute (TransactionAttributeType.REQUIRED)
public class PlaylistServiceEJB implements PlaylistService{

	Logger logger = Logger.getLogger("PlaylistEJB");
	
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private PlaylistDAO dao;
	
	@Resource
	private SessionContext context;

	@PostConstruct
	public void init() {
		logger.info("in PlaylistServiceEJB.init");
		logger.info(em.toString());
	}
	
	/**
	 * Sets the attached DAO to the EJB service
	 * @param dao new dao
	 */
	public void setDao(PlaylistDAO dao) {
		this.dao = dao;
	}

	@Override
	public void addPlaylists(Collection<Playlist> playlists) {
		dao.addPlaylists(playlists);
	}

	@Override
	public Collection<Playlist> getAllPlaylists() {
		// TODO Auto-generated method stub
		return dao.getAllPlaylists();
	}
}