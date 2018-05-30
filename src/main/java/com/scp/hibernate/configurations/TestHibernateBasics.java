package com.scp.hibernate.configurations;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestHibernateBasics {

	/**
	 * 
	 * DELETE
	 * DROP
	 * TRUNCATE
	 * 
	 * DML
	 * DDL
	 * TCL
	 * DCL
	 * 
	 * Following annotations
	 * 	Entity
	 * 	table
	 * 	id
	 * 	column
	 * 
	 * mapping resource
	 * mapping class
	 * 
	 * opensession vs getcurrentsession
	 * get vs load
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		//Employee e2 = new Employee(12,"John2","Pune",20000);
		//Employee e3 = new Employee(13,"John3","Mumbai",30000);

		
		//Employee e1 = new Employee("A","Pune",10000); //memory -- transient
		SessionFactory sFactory =new Configuration().configure().buildSessionFactory();

		
		Session s1 = sFactory.openSession();
		Transaction tr = s1.beginTransaction();
		//s1.persist(e1);
		s1.flush();
		tr.commit();
		s1.close(); //detached

		//e1.setAddress("Mumbai"); //memoery detached object is modified	
		
		Session s2 = sFactory.openSession();
		Transaction tr1 = s2.beginTransaction();
		//s2.persist(e1); //detached to persist
		tr1.commit();
		
		
		
		
		//save persist --- using generator
		
		
		
		
		
		
		
		
		/*Session session1 = sFactory.openSession();
		Transaction tr = session1.beginTransaction();
		session1.save(e1);//persistent
		session1.flush();
		tr.commit(); // 33 A Pune 10000
		session1.close(); //detached object
		
		e1.setAddress("Latur"); 
		e1.setEmpName("AMit");
		
		//DB --33 A Pune 10000
		//Memory --Detached -- 33 Amit Latur 10000 
		
		
		Session session2 = sFactory.openSession();
		Employee e2 = session2.get(Employee.class, 33);//33 A Pune 10000
		e2.setEmpName("Yogymax");
		Transaction tr1=session2.beginTransaction();
		session2.merge(e1); 
		// IN case of update exception -- org.hibernate.NonUniqueObjectException: A different object with the same identifier value was already associated with the session :
		//merge will work without an issue
		
		//e1 detached persistent
		session2.flush();
		tr1.commit(); // 33 A Pune 10000
		*/
		
		/*s1 -- save --s1 close -- object modify memory madhe
		s2 -- get -- s2 -- mofify -- s2 e1 -- 
		s2 -- e1 e2 -- e1 update
		*/	
		
		
		
		
		
		
		
		
		
		//DB --33 A Pune 10000
		//e1 -- 33 AMit Latur 10000 -- detached
		//e2 -- s2 --persistent -- 33 YOgymax Pune 10000
		
		
		
		//e1 -- memory -- detached -- 33 A Latur 10k
		//e2 -- memory (Session) -- persistent -- 33 AMit Pune 10k
		
		
		//update merge
		
		
		
		//Session session1=sFactory.openSession();
		//Session session2=sFactory.getCurrentSession();
		// org.hibernate.HibernateException: No CurrentSessionContext configured!
		//System.out.println(session2);
		
		
		
		
		
		
		/*Configuration config = new Configuration();
		SessionFactory sessionFactory = config.configure("/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		Query query =session.createSQLQuery("");
		*/
		
		//Session session= new Configuration().configure().buildSessionFactory().openSession();
		
/*		Transaction tr = session.beginTransaction();
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.flush();
		tr.commit();
*/		

	/*	System.out.println("before get");
		Employee dbE1 = session.get(Employee.class,10); //
		dbE1 = session.get(Employee.class,10); //id10 addr=p sal=10k
		
		
		
		Employee dbE2 = session.load(Employee.class,10); // i10 addr=null sal=0.0
		dbE2 = session.load(Employee.class,20); // id20 addr=null sal=0.0
		
		System.out.println("after get" +dbE1);
		System.out.println("after get" +dbE2);
*/
		
		/*System.out.println("before load");
		Employee dbE2 = session.load(Employee.class,12);
		System.out.println("afterload ");
		
		System.out.println("Get Output -- "+dbE1);
		//System.out.println(dbE2);
*/		
		
		
		
		
		
		
		
		/**
		 * get vs load
		 * 
		 * get eagar loading -- lazy -- on demand when you want actual data
		 * no record in db returns null -- throws excetion no row with given identifier exists
		 * 
		 * 
		 * 
		 * opensession vs getCurrentSession
		 * save vs saveupdate
		 * update vs merge
		 * update vs saveupdate
		 * session flush vs transcation commit
		 * save vs persist
		 */
		
		
		
		//Employee dbEmp = session.get(Employee.class,10);
		
		
		
		/**
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		
	
		
		
	/**	
	 * Configuration  -- class
	 * Sessionfactorcy  -- interface
	 * session -- interface
	 * transcation -- interface
	 * 
	 * 
	 * 
	 * query -- interface
	 * criteria -- interface
	 * 
	 * 
	 * 
	 * 
	 */
		
		
		
		
	}
	
}


/**
 * maven project
 * Pom.xml 
 * 		hibernate dependency add keli
 * 		db dependency
 * 
 * 
 * entity class
 * mapping file -- entity class --table
 * 					fields -- columns
 * 
 * 
 * hibernate configuartion -- 
 * 					db configurations
 * 					mapping resource -- mapping file
 *  
 * 
 * 
 * 
 * 
 */


/**

<!-- 
driverclass -- interface/bridge between database and java objects
dialect -- datatype conversions java to database specific datatypes
url -- 
		protocal -- set of rules for commiunication
		databasename -- name of your db
		machinename/ipaddress/hostname -- on which machine db is installed
		portno -- on which port database service are running in order communicate
		schemaname -- schemaname holds tables

username/password -- to give access to authenticated user only

Autheticatoin vs Authrization --

Authetication - credetials are correct or not
Authorization -- does that user has access to perticular resource --role

	Mysql   		
		<property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
		<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/<Schemaname></property>
		<property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
	oracle
		<property name="hibernate.connection.driver_class">oracle.jdbc.driver.OracleDriver</property>
		<property name="hibernate.connection.url">jdbc:oracle:thin:@127.0.0.1:1521:<schemaname></property>
		<property name="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</property>
	    -->

Sir let take an example
	where as we have s1 in which we are saving an object and once object persistestd in db
	we have an object  with value 10 A in db and in s1 10 A (Persistent)
	now i am detaching the object from s1 but that object will be in memory 
	and now we are modifying the values of detached object lets say 10,B
	DB -- 10,A
	S1 - nothing why becoz s1 is closed no more
	memory -- 10,B
	
	
	now i have a s2 in which i am loading an object from DB in s2 (persistance)
	
	
	
	DB -- 10,A
	S1 - nothing why becoz s1 is closed no more
	memory e1 -- 10,B -- detached
	s2 -- e2 - 10,A -- 10,C
	s2.update(e1) //detached to persistance -- it will fail
	s2.merge(e1) //will work 
	
	
	at a time one session with two object (one object is coming from detached to persistence)but with same identifier update will
	fail however merge will work
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	






*/