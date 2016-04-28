package com.chrismuldoon.jee.jaxrs;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.chrismuldoon.development.entities.Playlist;
import com.chrismuldoon.development.services.PlaylistService;


@Path("/playlist")
public class PlaylistCRUDService {
	
	@Inject
	private PlaylistService service;
	/**
	 * Get list of users
	 * @return UsersList list of all users
	 */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Playlist> getPlaylists() {
    	Collection<Playlist> playlists = service.getAllPlaylists();  
        return playlists;
    }
    
    @GET
  	@Path("/getPlaylistsInLibrary/{libraryPersistentId}")
  	@Produces(MediaType.APPLICATION_JSON)
  	public Collection<Playlist> getAllPlaylistsInLibrary(@PathParam("libraryPersistentId") String libraryPersistentId){
  		return service.getAllPlaylistsInLibrary(libraryPersistentId);
  	}
    
    @GET
  	@Path("/getPlaylistNames")
  	@Produces(MediaType.APPLICATION_JSON)
  	public Collection<String> getPlaylistsNames(){
  		return service.getPlaylistsNames();
  	}
}