package com.ora.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ora.dao.FeedbackDAO;
import com.ora.dao.FeedbackDAOImpl;
import com.ora.dao.MechanicDAO;
import com.ora.dao.MechanicDAOImpl;
import com.ora.dao.ServiceDAO;
import com.ora.dao.ServiceDAOImpl;
import com.ora.dao.UserDAO;
import com.ora.dao.UserDAOImpl;
import com.ora.entity.Service;

public class MechanicServiceImplTest {
	MechanicDAO mda;
	ServiceDAO sd;
	FeedbackDAO fd;
	@Before
	public void setUp()
	{
		mda=new MechanicDAOImpl();
	 sd=new ServiceDAOImpl();
		 fd=new FeedbackDAOImpl();
	}
	
	@After
	public void tearDown()
	{
		mda=null;
		sd=null;
		fd=null;
	}
	

	@Test
	public void testViewRequest(Service service) {
		assertNotNull(sd.viewService(service));
	}

	@Test
	public void testViewFeedback() {
		assertNotNull(fd.viewFeedback());
	}

}
