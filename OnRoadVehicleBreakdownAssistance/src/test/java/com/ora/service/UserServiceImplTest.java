package com.ora.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ora.dao.UserDAO;
import com.ora.dao.UserDAOImpl;
import com.ora.entity.Mechanic;
import com.ora.entity.User;
import com.ora.util.JPAUtil;

public class UserServiceImplTest {
	UserDAO obj;
	List<Mechanic> list;
	@Before
	public void setUp()
	{
		obj=new UserDAOImpl();
		
	}
	
	@After
	public void tearDown()
	{ 
		obj=null;
	}

	@Test
	public void testAddUser(User user) {
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();		
		Query q = entityManager.createQuery("FROM User");
		list=q.getResultList();
		entityManager.close();
		assertNotNull(list);
	}

	@Test
	public void testUpdateUser() {
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();		
		Query q = entityManager.createQuery("FROM User");
		List<Mechanic> list1=q.getResultList();
		entityManager.close();
		assert(list1.equals(list));
		
	}

}
