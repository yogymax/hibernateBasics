package com.scp.hibernate.configurations;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="EMP_INFOR")
public class Employee {
	
	
	
	@Id
	@Column(name="EMP_ID")
	private int empId;
	
	@Column(name="EMP_NAME")
	private String empName;
	
	@Column(name="EMP_ADDRESS")
	private String address;
	
	private double salary;
	
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "\n Employee [empId=" + empId + ", empName=" + empName
				+ ", address=" + address + ", salary=" + salary + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String empName, String address, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.address = address;
		this.salary = salary;
	}
	
	
	

	
	
	
	
	
}
