package com.ora.dao;

import java.util.List;

import com.ora.entity.Service;

public interface ServiceDAO {
	
	public Service addService(Service service);
	public List<Service> viewService(Service service);

}
