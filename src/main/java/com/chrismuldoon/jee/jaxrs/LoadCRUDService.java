package com.chrismuldoon.jee.jaxrs;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.chrismuldoon.development.services.LoadService;

@Path("/load")
public class LoadCRUDService {
	
	@Inject
	private LoadService loadService;
		
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public String getTracksList(){
		loadService.LoadData();
		return "hello";
	}
}
