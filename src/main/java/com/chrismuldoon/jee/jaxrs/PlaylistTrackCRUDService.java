package com.chrismuldoon.jee.jaxrs;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.chrismuldoon.development.entities.PlaylistTrackList;
import com.chrismuldoon.development.services.PlaylistTrackService;

@Path("/playlistTrack")
public class PlaylistTrackCRUDService {

	@Inject
	private PlaylistTrackService service;
	/**
	 * Get list of users
	 * @return UsersList list of all users
	 */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PlaylistTrackList getPlaylistTracks() {
    	PlaylistTrackList playlistTracks = new PlaylistTrackList();
    	playlistTracks.setPlaylistTrackCollection(service.getAllPlaylistTracks());  
        return playlistTracks;
    }
}