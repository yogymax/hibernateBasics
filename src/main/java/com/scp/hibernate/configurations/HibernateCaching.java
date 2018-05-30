package com.scp.hibernate.configurations;

import org.hibernate.Session;

import com.scp.utilties.SessionFactoryUtil;

public class HibernateCaching {

	public static void main(String[] args) throws Exception {
		
			Session session1 = SessionFactoryUtil.getSession();
			System.out.println("SessionCreated...");
			Employee e1= session1.get(Employee.class,33);
			System.out.println("e1 get" +e1);
			session1.evict(e1);
			Employee e2= session1.get(Employee.class,33);
			System.out.println("e2 get" +e2);
			
			Session session2 = SessionFactoryUtil.getSession();
			System.out.println("session2 created");
			Employee e3= session2.get(Employee.class,33);
			System.out.println("e3 get" +e3);
			Employee e4= session2.get(Employee.class,33);
			System.out.println("e4 get" +e4);
			
		/**	
		 * Firstlevel Cache
		 * 		-- which is bydefault enabled you cannot disable it
		 * 		-- when object is loaded (get/load) into the session which will
		 * 			be cached bydefault.
		 * 		-- subsequent get/load will check the object in session
		 * 			if present then retrive it or else fire a query on db
		 * 		-- one session cached object will not be avaible for other session
		 * 		-- No extra configuration required
		 * 		--Domain Object
		 * 
		 * Second Level Cache -
		 * 			-- No by Default -- extra configuration required
		 * 			-- Hibernate doesnt provide second level cache implementation
		 * 			-- In order to have second level cache feature in your hiberante
		 * 				application you need to get a support of third party vendors
		 * 				thoese could be
    						EH Cache (This one we are going to use ? which support all (4) caching levels)
    						OS Cache
    						Swarm Cache
    						JBoss Cache

		 *	Second level Caching levels 
    			read-only: caching will work for read only operation.
    			nonstrict-read-write: caching will work for read and write but one at a time.
    			read-write: caching will work for read and write, can be used simultaneously.
    			transactional: caching will work for transaction.
		 * 
		 * 	Configuration for second level cache
		 * 		hibernate config
					 <property name="hibernate.cache.use_second_level_cache">true</property>
					  <property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
							(optional) <property name="net.sf.ehcache.configurationResourceName">/myehcache.xml</property>
					 	 
			Sessionfacotry level cache
			First check into session n then in sesssionfactory if present
			load it into session if not then fetch it from db
			Same cached object will be avaible for all the session of that sessoinfactory
			
			Domain Object
			
		 * 
		 * Query Cahce
		 * 		Second level cache -- enable
		 * 		query.setcachable(True)
		 * 		-- Resultsset and queries		
		 * 				
		
		 <!-- enable second level cache and query cache -->
		
		 <property name="hibernate.cache.use_query_cache">true</property>
 	

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


