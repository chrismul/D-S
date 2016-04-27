package com.chrismuldoon.development.dao.jpa;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.chrismuldoon.development.dao.LibraryDAO;
import com.chrismuldoon.development.entities.Library;
import com.chrismuldoon.development.entities.User;

@Stateless
@Local
public class JPALibraryDAO implements LibraryDAO{

static Logger logger = Logger.getLogger("JPALibraryDAO");
	
	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	public void init() {
		logger.info("in JPALibraryDAO.init");
		logger.info(em.toString());
	}
	
	private String username;

	@SuppressWarnings("unchecked")
	@Override
	public void addLibrary(Library library) {
		Query query = em.createQuery("from Library");
		List<Library> libraries = query.getResultList();
		currentUser();
			if(!libraries.contains(library)){
				User u = em.find(User.class, username);
				if(library.getUser()==null){
					library.setUser(em.find(User.class, username));
					logger.info(u.getUsername());
				}
				em.merge(library);
			}
	}
	
	public void currentUser(){
    	Subject currentUser = SecurityUtils.getSubject();
    	username = currentUser.getPrincipal().toString();
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Library> getAllLibraries() {
		Query query = em.createQuery("from Library");
		List<Library> libraries = query.getResultList();
		return libraries;
	}

}
