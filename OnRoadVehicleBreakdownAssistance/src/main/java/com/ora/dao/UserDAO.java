package com.ora.dao;

import java.util.List;

import com.ora.entity.User;

public interface UserDAO {
	public void addUser(User user);
	public User updateUser(User user);
	public List<User> viewUserDetails();
	

}
