/*package com.scp.hibernate.configurations;

import java.util.HashMap;
import java.util.HashSet;

public class CollectionSet {

	*//**
	 * Duplicates not allowed
	 * Sequence not preserved
	 * Single null is allowed
	 * 
	 * @param args
	 *//*
	
	HashMap<Integer,Object> map = new HashMap<>() ;
	
	
	
	
	public void m1(){
		map.put(10,"");
	}
	
	public static void main(String[] args) {

		//hashcode -- address -- hash -- index 
		//Equals  -- address -- ref equality
		
		Emp e1 = new Emp(10,"A","Pune");//1 
		Emp e2 = new Emp(10,"A","Pune");//2
		Emp e3 = new Emp(10,"A","Mumbai");//3
		Emp e4 = new Emp(10,"A","Mumbai");//3
		Emp e5 = new Emp(10,"A","latur");//3
		Emp e6 = new Emp(10,"A","Latur");//4
		//put e1 -- null
		//put e2 -- null
		//put e7 -- value
		
		
		
		
		
		
		
		
		*//**
		 * hashset
		 * 		add(key)
		 * 
		 * 			put -- 
		 * 					if no duplicate -- returns null
		 * 					if duplicate found --replace existing value with new value and return existing value
		 * 
		 * 
		 * 			Object  map.put(k,v)
		 * 					if(k==null)
		 * 						putfornull
		 * 					
		 * 				index = k.hashcode -- hash -- indexFor
		 * 				index = bucket loction = 16 are the buckets
		 * 			
		 * 				Entry<K,V> eO = bucket[index];
		 * 				for(eo;eo!=null,e.next){
		 * 						equals and hash ==
		 * 						duplicate --
		 * 
		 * 
		 * 				}
		 * 
		 * 				addentry(k,v,h,i)
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * put
		 * add
		 * return values
		 * kadhi kay return hot
		 * 
		 * hashcode
		 * equals
		 * 
		 * 
		 * overridde kel tr kay 
		 * nah override kel tr kay
		 * 
		 * 
		 * 
		 *//*
		
		//HashSet<Emp> setOfEmps = new HashSet<>(); // Hashset C -- Hashmap C -- 16
		setOfEmps.add(e1);  //true
		//Put --  null
		//add null == null
		setOfEmps.add(e2);// false
		//put  -- p
		//add  -- p==null
		
		setOfEmps.add(e3);//true
		setOfEmps.add(e4);//
		setOfEmps.add(e5);//true
		setOfEmps.add(e6);//true
		
		System.out.println(setOfEmps.size());

		
		
		
		
		
		
		
		
	}
	
}


class Emp{
	private int empId;
	private String empName;
	private String empAddress;
	@Override
	public String toString() {
		return "\n Emp [empId=" + empId + ", empName=" + empName + ", empAddress="
				+ empAddress + "]";
	}
	public Emp(int empId, String empName, String empAddress) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((empAddress == null) ? 0 : empAddress.hashCode());
		//result = prime * result + empId;
		//result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (empAddress == null) {
			if (other.empAddress != null)
				return false;
		} else if (!empAddress.equals(other.empAddress))
			return false;
		if (empId != other.empId)
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}










*/