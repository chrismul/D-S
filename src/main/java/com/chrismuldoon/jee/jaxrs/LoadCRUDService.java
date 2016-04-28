package com.chrismuldoon.jee.jaxrs;

import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.chrismuldoon.development.services.LoadService;

@Path("/load")
public class LoadCRUDService {
	
	@Inject
	private LoadService loadService;
		
	@GET
	@Path("/{filename}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getTracksList(@PathParam("filename") String filename)throws URISyntaxException{
		java.net.URI location = null;

		loadService.LoadData(filename);
		location = new java.net.URI("http://localhost:8080/iTunesLibrary/home.jsp");
       	
    	
    	return Response.temporaryRedirect(location).build();
    }
}
