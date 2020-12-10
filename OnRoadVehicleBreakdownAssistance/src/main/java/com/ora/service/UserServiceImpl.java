package com.ora.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ora.dao.FeedbackDAO;
import com.ora.dao.FeedbackDAOImpl;
import com.ora.dao.MechanicDAO;
import com.ora.dao.MechanicDAOImpl;
import com.ora.dao.ServiceDAO;
import com.ora.dao.ServiceDAOImpl;
import com.ora.dao.UserDAO;
import com.ora.dao.UserDAOImpl;
import com.ora.entity.Feedback;
import com.ora.entity.Mechanic;
import com.ora.entity.Service;
//import com.ora.entity.Service;
import com.ora.entity.User;
import com.ora.util.JPAUtil;

public class UserServiceImpl implements UserService{
	UserDAO obj=new UserDAOImpl();
	MechanicDAO mda=new MechanicDAOImpl();
	FeedbackDAO fda=new FeedbackDAOImpl();
	public void addUser(User user) {
		
		obj.addUser(user);
		
	}

	public User updateUser(User user) {
		obj.updateUser(user);
		return user;
	}

	public List<Mechanic> searchMechanic(String location){
		return mda.searchMechanic(location);
	}

	public Service addRequest(Service service) {
	ServiceDAO sd=new ServiceDAOImpl();
	sd.addService(service);
		return null;
	}

	public Feedback giveFeedback(Feedback feedback) {
		return fda.addFeedback(feedback);
		
	}

	
}
