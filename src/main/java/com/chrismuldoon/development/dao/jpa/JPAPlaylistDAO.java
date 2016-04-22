package com.chrismuldoon.development.dao.jpa;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
}
