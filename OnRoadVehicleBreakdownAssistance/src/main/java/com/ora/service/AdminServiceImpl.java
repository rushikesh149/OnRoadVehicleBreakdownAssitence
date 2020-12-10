package com.ora.service;


import java.util.List;

import com.ora.dao.FeedbackDAO;
import com.ora.dao.FeedbackDAOImpl;
import com.ora.dao.MechanicDAO;
import com.ora.dao.MechanicDAOImpl;
import com.ora.dao.UserDAO;
import com.ora.dao.UserDAOImpl;
import com.ora.entity.Feedback;
import com.ora.entity.Mechanic;
import com.ora.entity.User;
import com.ora.exception.UserNotFoundException;

public class AdminServiceImpl implements AdminService {
	MechanicDAO mda=new MechanicDAOImpl();
	UserDAO uda=new UserDAOImpl();
	FeedbackDAO fd=new FeedbackDAOImpl();

public boolean addMechanic(Mechanic mcn){
		mda.addMechanic(mcn);
		return true;
}
public List<Mechanic> viewMechanicDetails()
{
     	return  mda.viewMechanicDetails();
	
}

public List<User> viewUserDetails()
{
     	return uda.viewUserDetails();
	
}

public List<Feedback> viewFeedback() {
	return fd.viewFeedback();
	
}


}














































