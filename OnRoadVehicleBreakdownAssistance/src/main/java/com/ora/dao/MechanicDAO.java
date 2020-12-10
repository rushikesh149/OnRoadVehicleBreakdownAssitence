package com.ora.dao;

import java.util.List;

import com.ora.entity.Mechanic;
import com.ora.entity.User;

public interface MechanicDAO {
	public List<Mechanic> viewFeedback(int mechanicId);
	public boolean addMechanic(Mechanic mechanic);
	public boolean login(int id,String pass);
	public Mechanic logOut(Mechanic mechanic); 
	public List<Mechanic> viewMechanicDetails();
	public List<Mechanic> searchMechanic(String location);
	

}
