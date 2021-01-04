package com.springboot.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.hospital.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	
	private EntityManager entityManager;
	
	@Autowired
	public UserDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
//	@Transactional // transaction annotation use is so that we dont have to manually start and commit transaction
	public List<User> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<User> theQuery = currentSession.createQuery("from User", User.class);
		
		return theQuery.getResultList();
	}

	@Override
	public User findById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(User.class, id);
	}

	@Override
	public void save(User user) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save user
		currentSession.saveOrUpdate(user); // remember if id = 0. perform insert, else then perform update.
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete object with primary
		Query query =  currentSession.createQuery(
				"delete from User where id =:userId");
		
		query.setParameter("userId", id);
		query.executeUpdate();
	}

}
