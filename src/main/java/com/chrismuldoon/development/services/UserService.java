package com.chrismuldoon.development.services;

import java.util.Collection;

import javax.ejb.Local;

import com.chrismuldoon.development.entities.User;

@Local
public interface UserService {
	public void addUser(User user);
	public User getUser(String username);
	public void updateUser(User user);
	public User removeUser(String username);
	public Collection<User> getAllUsers();
}
