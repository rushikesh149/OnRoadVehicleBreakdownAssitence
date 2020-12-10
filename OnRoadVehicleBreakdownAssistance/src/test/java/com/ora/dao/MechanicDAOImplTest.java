package com.ora.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ora.entity.Mechanic;
import com.ora.util.JPAUtil;

public class MechanicDAOImplTest {


	@Test
	public void testAddMechanic(Mechanic mechanic) {
		EntityManager entityManager =JPAUtil.getFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(mechanic);
		entityManager.getTransaction().commit();		
		Query q = entityManager.createQuery("FROM Mechanic");
		List<Mechanic> list=q.getResultList();
		entityManager.close();
		assertNotNull(list);
	}

	@Test
	public void testViewMechanicDetails() {
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();		
		Query q = entityManager.createQuery("FROM Mechanic");
		List<Mechanic> list=q.getResultList();
		entityManager.close();
		assertNotNull(list);
	}

}
