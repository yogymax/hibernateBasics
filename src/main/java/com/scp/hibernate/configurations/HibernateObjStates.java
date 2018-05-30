package com.scp.hibernate.configurations;

import org.hibernate.Session;

import com.scp.utilties.SessionFactoryUtil;

public class HibernateObjStates {

	public static void main(String[] args) {
		/**	
		 * T
		 * P
		 * D
		 *
		 * Note 
		 * 		remove
		 * 		delete
		 * Garbage Collection
		 */
		
		
		Mobiles m1 = new Mobiles(); // Transient
		
		Session session = null;
		
		
		for(int i=0;i<12;i++){
			try {
				session = SessionFactoryUtil.getSession();
				session.save(m1); // Per
				//session.remove(m1);// det
				session.evict(m1);// det
				
				System.out.println("No of times session Object = "+i);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		 
		
		
	}
	
}


class Mobiles{
	private int mobileId;
	private String mobileManufctr;
	
}
