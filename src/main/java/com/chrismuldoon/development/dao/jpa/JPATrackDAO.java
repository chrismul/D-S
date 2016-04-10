package com.chrismuldoon.development.dao.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.chrismuldoon.development.dao.TrackDAO;
import com.chrismuldoon.development.entities.Track;

@Stateless
@Local
public class JPATrackDAO implements TrackDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void addTrack(Track track) {
		
		Query query = em.createQuery("from Track");
		List<Track> tracks = query.getResultList(); 
		if (!tracks.contains(track))
			em.persist(track);
		
	}

	@Override
	public Track getTrackByTitle(String title) {
		Query query  = em.createQuery("from Track tr where tr.title = :title");
		query.setParameter("title", title);
		// remember we are assuming only one album has any particular title
		// could have used getSingleResult() but this an exception if there is more than one result
		List<Track> result = query.getResultList();
		return result.get(0);
	}

	@Override
	public Collection<Track> getTracksByArtist(String artist) {
		Query query  = em.createQuery("from Track tr where tr.artist = :artist");
		query.setParameter("artist", artist);
		List<Track> result = query.getResultList();
		return result;
	}

	@Override
	public Collection<Track> getAllTracks() {
		Query query = em.createQuery("from Track");
		List<Track> tracks = query.getResultList(); 
		return tracks;
	}
	

}
