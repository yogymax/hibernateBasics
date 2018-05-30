package com.scp.hibernate.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.scp.utilties.SessionFactoryUtil;

public class TestHibernateSecondLevelCache {

	public static void main(String[] args) {
		
		
		
			SessionFactory sFactory = SessionFactoryUtil.getSessionFactory();
			
			Laptop l1 = new Laptop(10,"Lenovo1","ThinkPad1",48000);
			/*Laptop l2 = new Laptop(11,"Lenovo2","ThinkPad2",42000);
			Laptop l3 = new Laptop(12,"Lenovo3","ThinkPad3",44000);
			Laptop l4 = new Laptop(13,"Lenovo4","ThinkPad4",46000);*/
			
			Session session1 = sFactory.openSession();
			Transaction tr = session1.beginTransaction();
			session1.save(l1);
			session1.flush();
			tr.commit();
			
			
			session1.evict(l1);
			System.out.println("evicted the object from session");
			
			System.out.println("before get");
			Laptop db1 = session1.get(Laptop.class,10);
			System.out.println("after get" +db1);
			session1.close();

			
			Session session2 = sFactory.openSession();
			System.out.println("before get ob using s2");
			Laptop db2 = session2.get(Laptop.class,10);
			System.out.println("after get ob using s2" +db2);
			
			
			
			
			
			
			
			
			
			
		
	}
	
}
