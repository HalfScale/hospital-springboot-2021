package com.springboot.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.hospital.model.User;

@Repository
public class UserJpaDAOImpl implements UserJpaDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public UserJpaDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<User> findAll() {
		TypedQuery<User> query = entityManager.createQuery("from User", User.class);
		
		return query.getResultList();
	}

	@Override
	public User findById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void save(User user) {
		
		// save or update the employee
		User dbUser = entityManager.merge(user);
		
		// update with id from db ... so we can get generated id for save/insert
		user.setId(dbUser.getId());
	}

	@Override
	public void deleteById(int id) {
		
		Query query = entityManager.createQuery("delete from User where id=:userId");
		
		query.setParameter("userId", id);
		query.executeUpdate();
	}

}
