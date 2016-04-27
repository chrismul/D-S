package com.chrismuldoon.jee.jaxrs;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.chrismuldoon.development.entities.LibraryList;
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
    public LibraryList getLibraries() {
    	LibraryList libraries = new LibraryList();
    	libraries.setLibraryCollection(service.getAllLibraries());  
        return libraries;
    }
 
}