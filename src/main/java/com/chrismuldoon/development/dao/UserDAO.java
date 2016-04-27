package com.chrismuldoon.development.dao;

import java.util.Collection;

import com.chrismuldoon.development.entities.User;

public interface UserDAO {
	public void addUser(User user);
	public User getUser(String username);
	public void updateUser(User user);
	public User removeUser(String username);
	public Collection<User> getAllUsers();
}
