package com.chrismuldoon.development.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.chrismuldoon.development.entities.Library;

@Local
public interface LibraryDAO {
	public void addLibrary(Library library);
	public Collection<Library> getAllLibraries();
	public Collection<Library> getUserLibraries(String username);
	public Collection<String> getLibraryPersistentIds();
}