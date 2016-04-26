package com.chrismuldoon.jee.jaxrs;

import java.net.URISyntaxException;

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
import javax.ws.rs.core.Response;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.chrismuldoon.development.entities.LibraryList;
import com.chrismuldoon.development.entities.User;
import com.chrismuldoon.development.entities.UserList;
import com.chrismuldoon.development.services.LibraryService;
import com.chrismuldoon.development.services.UserService;

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

	
	
	
    