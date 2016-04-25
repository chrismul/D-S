package com.chrismuldoon.jee.jaxrs;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;

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

import com.chrismuldoon.development.entities.User;
import com.chrismuldoon.development.entities.UserList;
import com.chrismuldoon.development.services.UserService;

@Path("/users")
public class UserCRUDService {

	@Inject
	private UserService service;
	
	/**
	 * Get list of users
	 * @return UsersList list of all users
	 */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserList getUsers() {
    	UserList users = new UserList();
    	users.setUserCollection(service.getAllUsers());  
        return users;
    }
    
    /**
     * Check logged in user's role and return a response to the user page
     * @return response user page
     * @throws URISyntaxException
     */
    @GET
    @Path("/userCheck")
    public Response checkRole() throws URISyntaxException{
    	java.net.URI location = null;
    	Subject currentUser = SecurityUtils.getSubject();
    	
    	location = new java.net.URI("http://localhost:8080/iTunesLibrary/query.jsp");
       	
    	
    	return Response.temporaryRedirect(location).build();
    }
    
    
    
    
    /**
     * Get username and role of current logged in user
     * @return collection with username and role
     */
    @GET
    @Path("/currentUser")
    @Produces(MediaType.APPLICATION_JSON)
    public String currentUser(){
    	Subject currentUser = SecurityUtils.getSubject();
  
    	String username = "";
    	
    	username = currentUser.getPrincipal().toString();
    	
    	return username;
    }
    
    /**
     * Add user to system
     * @param user
     */
    @POST
    @Path("/addUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addUser(User user) {
		user.setId(0);
		service.addUser(user);
	}
    
    @DELETE
    @Path("/{username}")
	public void removeUser(@PathParam("username") String username) {
		service.removeUser(username);
	}
    
    /**
     * Update user details
     * @param updatedUser
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(User updatedUser) {
		service.updateUser(updatedUser);
	}
    
    /**
     * Get username and role of current logged in user
     * @return collection with username and role
     */
//    @GET
//    @Path("/currentUser")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Collection<String> currentUser(){
//    	ArrayList<String> user = new ArrayList<String>();
//    	String username = "";
//    	
//    	user.add(username);
//    	
//    	return user;
//    }
    
}