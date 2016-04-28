package com.chrismuldoon.development.dao.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.chrismuldoon.development.dao.PlaylistDAO;
import com.chrismuldoon.development.entities.Playlist;

@Stateless
@Local
public class JPAPlaylistDAO implements PlaylistDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addPlaylists(Collection<Playlist> playlists) {
			for(Playlist playlist: playlists){
				em.merge(playlist);
			}
		}
		
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Playlist> getAllPlaylists() {
		Query query = em.createQuery("from Playlist");
		List<Playlist> playlists = query.getResultList();
		return playlists;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Playlist> getAllPlaylistsInLibrary(String libraryPersistentId) {
		Query query  = em.createQuery("from Playlist where libraryPersistentId = :libraryPersistentId");
		query.setParameter("libraryPersistentId", libraryPersistentId);
		List<Playlist> playlists = query.getResultList();
		return playlists;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<String> getPlaylistsNames(){
		Query query  = em.createQuery("select distinct playlistName from Playlist");
		List<String> result = query.getResultList();
		return result;
	}
	
}