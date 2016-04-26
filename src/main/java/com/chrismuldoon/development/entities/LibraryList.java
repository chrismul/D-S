package com.chrismuldoon.development.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class LibraryList implements Serializable {

	private static final long serialVersionUID = 1L;
	private Collection<Library> libraryCollection;
	
	/**
	 * Retrieves all rows from UserTable
	 * @return Collection of UserTable rows
	 */
	public Collection<Library> getLibraryCollection() {
        return libraryCollection;
    }
	
	/**
	 * Add a row to UsersTable
	 * @param Users object 
	 */
    public void setLibraryCollection(Collection<Library> libraryCollection) {
        this.libraryCollection = libraryCollection;
    }
}
