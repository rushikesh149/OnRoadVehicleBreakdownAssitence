package com.ora.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ora.entity.Service;
import com.ora.util.JPAUtil;

public class ServiceDAOImplTest {


	@Test
	public void testAddService(Service service) {
		EntityManager entityManager =JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(service);
		entityManager.getTransaction().commit();
		Query q = entityManager.createQuery("FROM Service");
		List<Service> list=q.getResultList();
		entityManager.close();
		assertNotNull(list);
		
	}

	@Test
	public void testViewService() {
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query q = entityManager.createQuery("FROM Service");
		List<Service> list=q.getResultList();
		for(Service m:list) {
			System.out.println(m.toString());
		}
		entityManager.close();
		assertNotNull(list);
	}

}
