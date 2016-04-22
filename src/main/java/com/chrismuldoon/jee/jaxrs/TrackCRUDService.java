package com.chrismuldoon.jee.jaxrs;

import java.util.*;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.chrismuldoon.development.entities.Track;
import com.chrismuldoon.development.entities.TrackList;
import com.chrismuldoon.development.entities.User;
import com.chrismuldoon.development.services.TrackService;

@Path("/tracks")
public class TrackCRUDService {

	@Inject
	private TrackService service;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public TrackList getTracks(){
		TrackList tracks = new TrackList();
		tracks.setTrackCollection(service.getAllTracks());
		return tracks;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addTrack(Track track) {
		track.setId(0); // make sure the ID is not set
		service.addTrack(track);
	}
	
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateTrack(Track updatedTrack) {
		service.updateTrack(updatedTrack);
	}
}
