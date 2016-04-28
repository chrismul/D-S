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

import com.chrismuldoon.development.dao.LibraryDAO;
import com.chrismuldoon.development.entities.Library;

@Stateless
@Local
@TransactionAttribute (TransactionAttributeType.REQUIRED)
public class LibraryServiceEJB implements LibraryService{

	Logger logger = Logger.getLogger("LibraryEJB");
	
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private LibraryDAO dao;
	
	@Resource
	private SessionContext context;

	@PostConstruct
	public void init() {
		logger.info("in LibraryServiceEJB.init");
		logger.info(em.toString());
	}
	
	/**
	 * Sets the attached DAO to the EJB service
	 * @param dao new dao
	 */
	public void setDao(LibraryDAO dao) {
		this.dao = dao;
	}

	@Override
	public void addLibrary(Library library) {
		dao.addLibrary(library);
	}

	@Override
	public Collection<Library> getAllLibraries() {
		// TODO Auto-generated method stub
		return dao.getAllLibraries();
	}
	
	@Override
	public Collection<Library> getUserLibraries(String username){
		return dao.getUserLibraries(username);
	}
	
	@Override
	public Collection<String> getLibraryPersistentIds(){
		return dao.getLibraryPersistentIds();
	}
}
