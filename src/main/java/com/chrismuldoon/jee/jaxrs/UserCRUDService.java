package com.chrismuldoon.jee.jaxrs;

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
     * Add user to system
     * @param user
     */
    @POST
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
    
}