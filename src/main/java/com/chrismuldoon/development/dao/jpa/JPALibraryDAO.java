package com.chrismuldoon.development.dao.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.chrismuldoon.development.dao.LibraryDAO;
import com.chrismuldoon.development.entities.Library;
import com.chrismuldoon.development.entities.Track;

@Stateless
@Local
public class JPALibraryDAO implements LibraryDAO{

	@PersistenceContext
	private EntityManager em;

	@Override
	public void addLibrary(Library library) {
		
			em.merge(library);
		
		
	}

}
