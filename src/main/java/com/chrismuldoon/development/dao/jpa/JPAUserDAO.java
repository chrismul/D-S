package com.chrismuldoon.development.dao.jpa;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.chrismuldoon.development.dao.UserDAO;
import com.chrismuldoon.development.entities.User;

@Default
@Stateless
@Local
@TransactionAttribute (TransactionAttributeType.REQUIRED)
public class JPAUserDAO implements UserDAO {

static Logger logger = Logger.getLogger("JPAUserDAO");
	
	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	public void init() {
		logger.info("in JPAUserDAO.init");
		logger.info(em.toString());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void addUser(User user) {
		Query query = em.createQuery("from User");
		List<User> users = query.getResultList();
		if (!users.contains(user)){
			em.merge(user);
		}        
    }

	@Override
	public User getUser(String username) {
		Query query = em.createQuery("from User where username=:username");
		query.setParameter("username", username);
		return (User) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateUser(User user) {
		Query query = em.createQuery("from User");
		List<User> users = query.getResultList();
		User existinguser = null;
		for(User thisUser:users){
			if(thisUser.getUsername().equals(user.getUsername())){
				existinguser=thisUser;
				user.setId(existinguser.getId());
				
			}
		}
		em.merge(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User removeUser(String username) {
		logger.info(username);
		Query query = em.createQuery("from User us where us.username=:username");
		query.setParameter("username", username);
		List<User> users = query.getResultList();
		User chosenUser = null;
		for(User u:users){
			if(u.getUsername().equals(username)){
				chosenUser = u;
				break;
			}
		}
		em.remove(chosenUser);
		return chosenUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<User> getAllUsers() {
		Query query = em.createQuery("from User");
		List<User> users = query.getResultList();
		return users;
	}

}
