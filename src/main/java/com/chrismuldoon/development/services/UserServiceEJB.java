package com.chrismuldoon.development.services;

import java.util.Collection;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.chrismuldoon.development.dao.UserDAO;
import com.chrismuldoon.development.entities.User;

@Stateless
@Local
@TransactionAttribute (TransactionAttributeType.REQUIRED)
public class UserServiceEJB implements UserService {

Logger logger = Logger.getLogger("UserEJB");
	
	@PersistenceContext
	private EntityManager em;
		
	@Inject
	private UserDAO dao;
	
	@Resource
	private SessionContext context;

	@PostConstruct
	public void init() {
		logger.info("in UserServiceEJB.init");
		logger.info(em.toString());
	}
	
	/**
	 * Sets the attached DAO to the EJB service
	 * @param dao new dao
	 */
	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	@Override
	public void addUser(User user) {
		dao.addUser(user);
	}

	@Override
	public User getUser(String username) {
		return dao.getUser(username);
	}

	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
	}

	@Override
	public User removeUser(String username) {
		return dao.removeUser(username);
	}

	@Override
	public Collection<User> getAllUsers() {
		return dao.getAllUsers();
	}

}
