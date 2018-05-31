package com.scp.hibernate.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

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
			
			
			session1.createQuery("select * from laptop_info where which_model = ?");
			session1.createQuery("select * from laptop_info where which_model = ?");
			
			
			
			
			System.out.println("before get");
			Laptop db1 = session1.get(Laptop.class,10);
			System.out.println("after get" +db1);
			session1.close();

			
			Session session2 = sFactory.openSession();
			System.out.println("before get ob using s2");
			Laptop db2 = session2.get(Laptop.class,10);
			System.out.println("after get ob using s2" +db2);
			Statistics stas = sFactory.getStatistics();
			stas.setStatisticsEnabled(true); //or <property name="hibernate.generate_statistics" value="true"/>
			
			
		
			
			
			
/**
 * 
 * 
 * why caching
 * types of caching
 * 1st vs 2nd vs query cache
 * disadvanges of caching
 * steps to configure 2nd level cache
 * steps to configure query level cache
 * list of differnt implemention - 2nd level caching
 * differnet caching stragergies-- explain
 * what is ehcache configuration files -- is a optional -- what are all
 * things you configure 
 * why ehcache not other
 * can we limit no of objects to be cached timetolive ideal for an cached objects
 * git example to showcase 2ndlevel cache and query cache
 * how does query cache works
 * write down the steps to load/get the objects from cache -- first check in session den sf n so on
 * 
 * https://github.com/yogymax/gitDemo/blob/master/src/com/scp/java/ten/hibernate/basics/HibernateBasics.java
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Disadvantages
 * 		-- of course performance -- why ? as you load many objects in to memory
 * 		-- in case db is updated from backend or other application or outside 
 * 			hibernate boundry -- your hibernate doesnt have intelligence to 
 * 			get the updated data
 * 		-- configuration -- jar compatibility issues
 * 		-- you should not go for second level cache-- if you have millions of
 * 			records in such a case you might end up with outofmemory issue
 * 
 * read only
 * 		when you actually save/persist/load/get the data from db that time it will be cached
 * Read-write
 * NOnStrictReadwrite
 * transactional - which is not supported in ehcache only supported in treecache impltn
 * 
 * 
 * 			
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
			
			
			
			
			
			
			
		
	}
	
}
