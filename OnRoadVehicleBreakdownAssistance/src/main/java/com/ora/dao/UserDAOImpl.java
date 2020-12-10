package com.ora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ora.entity.User;
import com.ora.util.JPAUtil;

public class UserDAOImpl implements UserDAO{
	public void addUser(User user) {
		EntityManager entityManager =JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			entityManager.close();
			System.out.println("User Added");
		
		}
	
	public List<User> viewUserDetails() {
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query q = entityManager.createQuery("FROM User");
		List<User> list=q.getResultList();
		return list;
		
	}
	
	public User updateUser(User user) {
		EntityManager entityManager= JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		entityManager.close();
		return user;
	}

}
