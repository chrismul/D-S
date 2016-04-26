package com.chrismuldoon.development.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.chrismuldoon.development.entities.Library;
import com.chrismuldoon.development.entities.User;


@Local
public interface LibraryDAO {
	public void addLibrary(Library library);
	public Collection<Library> getAllLibraries();
}