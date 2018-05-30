package com.scp.hibernate.configurations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateHbm2ddlProps {
	
/**
 * cpu Reg
 * 		-- First level cache
 * 				-- Session level cache
 * 				-- developer cannot disble this which is bydefault
 * 				--  no extra configuration is required
 * 		-- Second level Cache
 * 				-- sessionfactory level
 * 				-- hibernate doesn't provide 2nd level cache implementation
 * 					Implementations  are given by third party vendors
 * 						-- infinySpan
 * 						-- jBoss Cache
 * 						-- Ehcache etc ---
 	* 			-- you need add extra configuration
 	* 					-- hibernate.second.level.cache  true
 	* 					-- factoryRegionClass -- third party vendor java class name
 	* 					-- configuration file
 	* 				
 * 		-- Query Cache
 * 				-- 2nd level cache is mandatory to enable query cahce
 * 				-- resultsets and query will be cached
 * 
 * 
 * 
 * Three types of caching in hibernate
 * 		--
 * 
 * 
 * 
 * @param args
 */
	
	
	
	public static void main(String[] args) {

		
		Vehicle v1 = new Vehicle(10,"V1",1012);
		//Vehicle v2 = new Vehicle(11,"V2",332012);
		//Vehicle v3 = new Vehicle(12,"V3",412012);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session1 = sf.openSession();
		Transaction tr= session1.beginTransaction();
		session1.save(v1);
		session1.flush();
		tr.commit();
		session1.close();		
		Session session2 = sf.openSession();
		Transaction tr1= session2.beginTransaction();
		Vehicle v2 = session2.get(Vehicle.class,1);
		v2.setVechilePrice(10000);
		session2.save(v2);
		session2.flush();
		session2.close();
		
		
		
		/*Transaction tr= session.beginTransaction();
		session.save(v1);
		session.save(v2);
		session.save(v3);
		session.flush();
		tr.commit();*/
		//session.close();
		//sf.close();
		
	}

}

/**
 * 
 * Create - Drop
 * 		--At the time of sessionfactory instatiation 
 * 				--drops the schema -- to all data will be deleted
 * 	  			- creates the schema and table
 * 
 * 		At the time of sessionFactory loading - drop the table and create it
 * 		if(sf.close)
 * 			drop the table
 * 
 * create -
 * 		at the time of sessionFactory loading - drop the table and create it
 * 		Note - even if we close the sf no tables will be dropped
 * 
 * 	update 
 * 		
 * 		if no tables
 * 				create the tables
 * 		if tables already present 
 * 				add/update the records
 * 		if table column newly added
 * 				alter the table
 * 		you cannot change the column name it will be treated as new colmn
 * 
 * 
 * Note -- never performs drop
 * 			
 * 
 * validate -
 * 		check the scehma -- no action is performed at db side
 * 		NO create
 * 		No drop
 * 		No Alter
 * 		
 * 
 * NO default value for your hbm2ddl property
 * 
 * 
 * On production env we should avoid to to use hbm2ddl properties
 * update --
 * 
 * 
 * 
 * 
 *
 */


//Entity class

@Entity
@Table(name="vehicle_info")
class Vehicle{
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int vehicleId;
	private String vehicleName;
	@Column(name= "vechilep")
	private long vechilePrice;
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public long getVechilePrice() {
		return vechilePrice;
	}
	public void setVechilePrice(long vechilePrice) {
		this.vechilePrice = vechilePrice;
	}
	public Vehicle(int vehicleId, String vehicleName, long vechilePrice) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
		this.vechilePrice = vechilePrice;
	}
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	
	
}


/**
 * 
 * 
 * search -- hbm2ddl properties
 * stackoverflow - 24 thread 
 *Ctrl+q -- last changes 
 */
