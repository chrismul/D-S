package com.chrismuldoon.jee.jaxrs;


import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.chrismuldoon.development.entities.Library;
import com.chrismuldoon.development.services.LibraryService;

@Path("/library")
public class LibraryCRUDService {

	@Inject
	private LibraryService service;
	
	/**
	 * Get list of users
	 * @return UsersList list of all users
	 */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Library> getLibraries() {
    	Collection<Library> libraries = service.getAllLibraries();  
        return libraries;
    }
 
}