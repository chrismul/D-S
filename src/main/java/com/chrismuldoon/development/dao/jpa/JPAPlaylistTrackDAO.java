package com.chrismuldoon.development.dao.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.chrismuldoon.development.dao.PlaylistTrackDAO;
import com.chrismuldoon.development.entities.PlaylistTrack;

@Stateless
@Local
public class JPAPlaylistTrackDAO implements PlaylistTrackDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addPlaylistTracks(Collection<PlaylistTrack> playlistTracks) {
			for(PlaylistTrack playlistTrack: playlistTracks){
				em.merge(playlistTrack);
			}
		}
		
	@SuppressWarnings("unchecked")
	@Override
	public Collection<PlaylistTrack> getAllPlaylistTracks() {
		Query query = em.createQuery("from PlaylistTrack");
		List<PlaylistTrack> playlistTracks = query.getResultList();
		return playlistTracks;
	}
}