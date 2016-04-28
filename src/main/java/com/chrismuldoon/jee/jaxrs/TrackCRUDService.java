package com.chrismuldoon.jee.jaxrs;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.chrismuldoon.development.entities.Track;
import com.chrismuldoon.development.services.TrackService;

@Path("/tracks")
public class TrackCRUDService {

	@Inject
	private TrackService service;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Collection<Track> getTracks(){
		Collection<Track> tracks = service.getAllTracks();
		return tracks;
	}
    
    /**
     * Gets a list of results from a query
     * @return A list of Base data results
     */
    @Path("/il-1/{genre}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public Collection<Track> getTracksByGenre(@PathParam("genre") String genre) {
        return service.getTracksByGenre(genre);
    }
    
    /**
     * Gets a list of results from a query
     * @return A list of Base data results
     */
    @Path("/il-2/{artist}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public Collection<Track> getTracksByArtist(@PathParam("artist") String artist) {
        return service.getTracksByArtist(artist);
    }
    
    /**
     * Gets a list of results from a query
     * @return A list of Base data results
     */
    @Path("/artists")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public Collection<String> getAllArtists() {
        return service.getAllArtists();
    }
    /**
     * Gets a list of results from a query
     * @return A list of Base data results
     */
    @Path("/genres")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public Collection<String> getAllGenres() {
        return service.getAllGenres();
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addTrack(Track track) {
		track.setTrackId(0); // make sure the ID is not set
		service.addTrack(track);
	}
	
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateTrack(Track updatedTrack) {
		service.updateTrack(updatedTrack);
	}
	  
    

}
