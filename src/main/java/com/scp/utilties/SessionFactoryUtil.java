package com.scp.utilties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
	
	private static SessionFactory sFactory =null;
	private static final int MAX_SESSION=10;
	private static int counter = 0;
	
	public static SessionFactory getSessionFactory(){
		if(null==sFactory){
			sFactory = new Configuration().configure().buildSessionFactory();
		}
		
		return sFactory;
	}
	
	/**
	 * 
	 * 			JPA java persistence API
	 * 			remove
	 * 			delete
	 * Hibernate
	 * 			evict
	 * Ibatis
	 * TopLink
	 * EclipseLink
	 * Apache OpenJPA
	 * 
	 * 
	 * 
	 * 
	 * @return
	 * @throws Exception
	 */
	
	
	@SuppressWarnings("unused")
	public static Session getSession() throws Exception{
		Session session =null;
		if(counter <=MAX_SESSION){
			session = getSessionFactory().openSession();
			counter++;
		}else{
			throw new Exception("No of session limit exceed");
		}
		
		return session;
		

			
	}
	

}
