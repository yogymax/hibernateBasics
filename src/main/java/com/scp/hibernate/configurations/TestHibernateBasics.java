package com.scp.hibernate.configurations;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestHibernateBasics {

	public static void main(String[] args) {
		Employee e1 = new Employee(10,"John1","Pune",10000);
		Employee e2 = new Employee(12,"John2","Pune",20000);
		Employee e3 = new Employee(13,"John3","Mumbai",30000);
		
		
		/*Configuration config = new Configuration();
		SessionFactory sessionFactory = config.configure("/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		Query query =session.createSQLQuery("");
		*/
		
		Session session= new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory().openSession();
		
		Transaction tr = session.beginTransaction();
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.flush();
		tr.commit();
		
		
		Employee dbEmp = session.get(Employee.class,10);
		
		
		
		
	
		
		
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


*/