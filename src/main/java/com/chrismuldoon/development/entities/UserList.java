package com.chrismuldoon.development.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class UserList implements Serializable{

	private static final long serialVersionUID = 1L;
	private Collection<User> userCollection;
	
	/**
	 * Retrieves all rows from UserTable
	 * @return Collection of UserTable rows
	 */
	public Collection<User> getUserCollection() {
        return userCollection;
    }
	
	/**
	 * Add a row to UsersTable
	 * @param Users object 
	 */
    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

}