package com.ora.service;

import java.util.List;

import com.ora.entity.Feedback;
import com.ora.entity.Mechanic;
import com.ora.entity.Service;
import com.ora.entity.User;

public interface UserService {
	

		public void addUser(User user);
		public User updateUser(User user);
		public List<Mechanic> searchMechanic(String location);
		public Service addRequest(Service service);
		public Feedback giveFeedback(Feedback feedback);
		

}

