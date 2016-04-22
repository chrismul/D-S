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

import com.chrismuldoon.development.services.LoadService;


@Path("/playlist")
public class PlaylistCRUDService {
	

	@Inject
	private LoadService loadService;
	
	@Path("/list")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public String getPlaylistsList(){
		loadService.LoadData();
		return "hello";
	}
}