package com.chrismuldoon.development.services;

import java.util.Collection;

import javax.ejb.Local;

import com.chrismuldoon.development.entities.Library;

@Local
public interface LibraryService {
	public void addLibrary(Library library);
	public Collection<Library> getAllLibraries();
}

