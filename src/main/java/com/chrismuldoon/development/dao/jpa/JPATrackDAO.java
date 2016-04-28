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

	@SuppressWarnings("unchecked")
	@Override
	public void addTrack(Track track) {
		Query query = em.createQuery("from Track");
		List<Track> tracks = query.getResultList(); 
		if (!tracks.contains(track))
			em.persist(track);
	}
	
	
	@Override
	public void addTracks(Collection<Track> tracks) {
		for(Track track: tracks){
			em.merge(track);
		}
	}

	@Override
	public Track getTrack(String name) {
		Query query  = em.createQuery("from Track where name=:name");
		query.setParameter("name", name);
		return (Track) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateTrack(Track track) {
		Query query  = em.createQuery("from Track");
		List<Track> tracks = query.getResultList();
		Track existingTrack = null;
		for(Track thisTrack:tracks){
			if(thisTrack.getName().equals(track.getName())){
				existingTrack=thisTrack;
				track.setTrackId(existingTrack.getTrackId());
			}
		}
		em.merge(track);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Track> getTracksByArtist(String artist) {
		Query query  = em.createQuery("from Track where artist=:artist");
		query.setParameter("artist", artist);
		List<Track> result = query.getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Track> getTracksByGenre(String genre) {
		Query query  = em.createQuery("from Track where genre=:genre");
		query.setParameter("genre", genre);
		List<Track> result = query.getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Track> getTracksByAlbum(String albumName) {
		Query query  = em.createQuery("from Track where album=:albumName");
		query.setParameter("albumName", albumName);
		List<Track> result = query.getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Track> getAllTracks() {
		Query query = em.createQuery("from Track");
		List<Track> tracks = query.getResultList(); 
		return tracks;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Collection<String> getAllGenres() {
		Query query = em.createQuery("select distinct tr.genre from Track tr");
		List<String> genres = query.getResultList();
		return genres;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<String> getAllArtists() {
		Query query = em.createQuery("select distinct tr.artist from Track tr");
		List<String> artists = query.getResultList();
		return artists;
	}


	
}
