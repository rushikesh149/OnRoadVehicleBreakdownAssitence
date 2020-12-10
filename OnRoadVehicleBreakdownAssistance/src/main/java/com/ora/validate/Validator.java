package com.ora.validate;

import com.ora.exception.UserNotFoundException;

public class Validator {
	
	
	public boolean validateUser(String adminId,String adminPassword) throws UserNotFoundException{
		boolean flag=false;
		
		try
		{
			if(adminId.equals("Admin") && adminPassword.equals("Admin123"))
			{
				System.out.println("Validated");
				flag=true;
			}
			else
			{
				throw new UserNotFoundException("User Not Found for Given User Name and Password");
			}
		}
		catch(UserNotFoundException e)
		{
			e.getMessage();
		}
		return flag;
	}
	
	

}
