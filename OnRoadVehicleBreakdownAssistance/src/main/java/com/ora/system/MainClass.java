package com.ora.system;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

import com.ora.dao.UserDAO;
import com.ora.dao.UserDAOImpl;
import com.ora.entity.Feedback;
import com.ora.entity.Mechanic;
import com.ora.entity.Service;
import com.ora.entity.User;
import com.ora.exception.InvalidException;
import com.ora.exception.UserNotFoundException;
import com.ora.service.AdminService;
import com.ora.service.AdminServiceImpl;
import com.ora.service.MechanicService;
import com.ora.service.MechanicServiceImpl;
import com.ora.service.UserService;
import com.ora.service.UserServiceImpl;
import com.ora.validate.Validator;

public class MainClass {
	Mechanic mechanic;

	public static void main(String[] args) throws UserNotFoundException {

		AdminService ads = new AdminServiceImpl();
		MechanicService mcn = new MechanicServiceImpl();
		UserService ucn = new UserServiceImpl();
		Validator v = new Validator();

		Scanner scn = new Scanner(System.in);
		System.out.println("On Road Vehicle Breakdown Assistance");
		System.out.println("-----------------------------------------------------------");
		System.out.println("1.Admin");
		System.out.println("2.Mechanic");
		System.out.println("3.User");
		System.out.println("4.Exit");
		System.out.println("Enter Choice:");
		int choice = scn.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Welcome for Admin Login");
			System.out.println("-----------------------------------------------------------");
			scn.nextLine();
			System.out.println("Enter Admin Name");
			String adminId = scn.nextLine();
			System.out.println("Enter Password");
			String adminpassword = scn.nextLine();
			boolean admin = v.validateUser(adminId, adminpassword);
			if (admin) {
				System.out.println("Welcome Admin ");
				System.out.println("-----------------------------------------------------------");
				do {
					System.out.println(
							"1.Add Mechanic\n2.View Mechanic\n3.View User\n4.View Feedback\n5.AllowOrBlockMechanic\n6.Exit");
					System.out.println("Enter choice:");
					int choice1 = scn.nextInt();
					switch (choice1) {
					case 1:
						System.out.println("Enter the id:");
						int userId = scn.nextInt();
						scn.nextLine();
						System.out.println("Enter the Name: ");
						String mname = scn.nextLine();
						System.out.println("Enter the Password: ");
						String mpass = scn.nextLine();
						System.out.println("Enter the Email: ");
						String memail = scn.nextLine();
						System.out.println("Enter the Phone Number: ");
						BigInteger phone = scn.nextBigInteger();
						scn.nextLine();
						System.out.println("Enter the Service Type: ");
						String servicetype = scn.nextLine();
						System.out.println("Enter the Location: ");
						String location = scn.next();
						try {
							Mechanic mcnentity = new Mechanic(userId, mname, mpass, memail, phone, servicetype,
									location);
							boolean add = ads.addMechanic(mcnentity);
							if (add) {
								System.out.println("Mechanic Added Successfully");
							} else {
								throw new InvalidException("Mechanic Not Added");
							}
						} catch (InvalidException e) {
							e.printStackTrace();

						}
						break;

					case 2:
						List<Mechanic> list=ads.viewMechanicDetails();
						System.out.println("-------------Displaying Mechanic Details------------");
						System.out.println();
						System.out.println("Mechanic Name" + "\t" + "Mechanic Email Id" + "\t" + "Mechanic Phone Number"+"\t" + "Mechanic Service Type"+"\t" + "Mechanic location");
						for (Mechanic m: list) {
							System.out.println( m.getMechanicName() + "\t\t" + m.getMechanicEmailId() + "\t\t" + m.getMechanicPhoneNumber()+ "\t\t" + m.getMechanichServiceType()+ "\t\t" + m.getLocation());
						}

						break;
						
					case 3:
						List<User> list11=ads.viewUserDetails();
						System.out.println("-------------Displaying User Details------------");
						System.out.println();
						System.out.println("User Name"+"\t"+"User Email Id"+"\t"+"User Phone Number");
						for(User u : list11) {
							System.out.println(u.getUserName()+"\t"+u.getUserEmailId()+"\t"+u.getUserPhoneNumber());
						}
						break;
						
					case 4:
						List<Feedback> list12=ads.viewFeedback();
						System.out.println("-------------Displaying Feedback Details------------");
						System.out.println();
						System.out.println("User Id"+"\t"+"Mechanic Id"+"\t"+"Feedback"+"\t"+"Ratings");
						for(Feedback f : list12) {
							System.out.println(f.getUserId()+"\t"+f.getMechanicId()+"\t"+f.getFeedback()+"\t"+f.getRatings());
						}
						break;
					case 6:
						break;
						

					}
					

				} while (true);

			} else {
				System.out.println("Invalid Details");
				System.exit(0);
			}
			break;
		case 2:

		}

//		System.out.println("Enter the id:");
//		int userId=scn.nextInt();
//		scn.nextLine();
//		System.out.println("Enter the Name: ");
//		String mname=scn.nextLine();
//		System.out.println("Enter the Password: ");
//		String mpass=scn.nextLine();
//		System.out.println("Enter the Email: ");
//		String memail=scn.nextLine();
//		System.out.println("Enter the Phone Number: ");
//		BigInteger phone=scn.nextBigInteger();
//		scn.nextLine();
//		System.out.println("Enter the Service Type: ");
//		String servicetype=scn.nextLine();	
//		System.out.println("Enter the Location: ");
//		String location=scn.next();
//		Mechanic mcn=new Mechanic(userId,mname,mpass,memail,phone,servicetype,location);
//		AdminServiceImpl ads = new AdminServiceImpl();
//		ads.addMechanic(mcn); 
//		ads.viewMechanicDetails();
//
//        System.out.println("Enter the Id for update: ");
//		int uid=scn.nextInt();
//		scn.nextLine();
//		System.out.println("Enter the Name: ");
//		String uname=scn.nextLine();
//		System.out.println("Enter the Password: ");
//		String upass=scn.nextLine();
//		System.out.println("Enter the Email: ");
//		String uemail=scn.nextLine();
//		System.out.println("Enter the Phone Number: ");
//     	BigInteger phone=scn.nextBigInteger();
//      	scn.nextLine();
//		User user=new User(uid,uname,upass,uemail,phone);
//		UserService obj=new UserServiceImpl();
//		//obj.addUser(user);
//		
//		obj.updateUser(user);
//    	
//
//		System.out.println("Enter the Id for service: ");
//		int sid = scn.nextInt();
//		scn.nextLine();
//		System.out.println("Enter the service type:");
//		String serviceType=scn.nextLine();
//		System.out.println("Enter user id:");
//		int userId=scn.nextInt();
//		System.out.println("Enter location:");
//		String location=scn.next();
//Service service=new Service(sid,serviceType,userId,location);
		// UserService obj=new UserServiceImpl();
//		obj.searchMechanic(location);
//		Service service=new Service();
//		MechanicService obj = new MechanicServiceImpl();
//		obj.viewRequest(service);
//		System.out.println("Enter feedback id:");
//		int fid=scn.nextInt();
//		scn.nextLine();
//		System.out.println("Enter feedback:");
//		String feedback=scn.nextLine();
//		System.out.println("Enter user id:");
//		int userId=scn.nextInt();
//		System.out.println("Enter mechanic id:");
//		int mechanicId=scn.nextInt();
//		System.out.println("Enter ratings:");
//		float ratings=scn.nextFloat();
//		Feedback feed=new Feedback(fid,userId,mechanicId,feedback,ratings);
//		obj.giveFeedback(feed);
//		AdminServiceImpl ads = new AdminServiceImpl();
//		Feedback feedback = new Feedback();
//		ads.viewFeedback(feedback);
	}

}
