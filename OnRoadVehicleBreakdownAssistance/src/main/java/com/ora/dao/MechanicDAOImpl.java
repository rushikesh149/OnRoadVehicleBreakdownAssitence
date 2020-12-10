package com.ora.dao;

import java.util.List;
import com.ora.entity.Mechanic;
import com.ora.entity.User;
import com.ora.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


//import com.o.util.DBUtil;

public class MechanicDAOImpl implements  MechanicDAO {
	EntityManager manager;
	
	public boolean addMechanic(Mechanic mechanic) {
		EntityManager entityManager =JPAUtil.getFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(mechanic);
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}
	
	public List<Mechanic> viewMechanicDetails() {
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query q = entityManager.createQuery("FROM Mechanic");
		List<Mechanic> list=q.getResultList();
		return list;
		
	}
	
	public List<Mechanic> searchMechanic(String location){
		EntityManager entityManager =JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query q = entityManager.createQuery("FROM Mechanic m WHERE m.location=?");
		q.setParameter(1,location);
		List<Mechanic> list=q.getResultList();
		for(Mechanic m:list) {
			System.out.println(m.toString());
		}
		
		return list;
	}

	

	public List<Mechanic> viewFeedback(int mechanicId) {
		TypedQuery<Mechanic> query=manager.createQuery("select cc.feedback from Feedback cc where cc.mechanic_Id=:mechanicId",Mechanic.class);
		query.setParameter("mechanicId", mechanicId);
		List<Mechanic> list=query.getResultList();
		return list;
	}

	
	
	public boolean login(int id,String pass) {
//		 System.out.println("Enter mechanic ID");
//		 int id=new Scanner(System.in).nextInt();
//		 System.out.println("Enter your Password");
//		 String pass=new Scanner(System.in).nextLine();
		// select password Where mechanich_id==id; take password and check is equalto pass or not
		 TypedQuery<Mechanic> query=manager.createQuery("select cc.password from mechanic_info cc where cc.mechanic_id=:id",Mechanic.class);
			query.setParameter("id",id);
			String password1=query.getSingleResult().toString();
			if(pass.equals(password1))
			{
				return true;
			}
		 return false;
	}

	public Mechanic logOut(Mechanic mechanic) {
		// TODO Auto-generated method stub
		 System.exit(0);
		 return null;
	}

}