package com.scp.hibernate.caching;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Table(name="laptop_info")
@Cache(usage= CacheConcurrencyStrategy.READ_ONLY)
public class Laptop {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;

	@Column(name="lappy_name")
	private String name;
	
	@Column(name="which_model")
	private String modelName;
	
	@Column(name="lappy_price")
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Laptop(int id, String name, String modelName, double price) {
		super();
		this.id = id;
		this.name = name;
		this.modelName = modelName;
		this.price = price;
	}

	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "\n Laptop [id=" + id + ", name=" + name + ", modelName="
				+ modelName + ", price=" + price + "]";
	}
	
	
	
	
	
	
	
	

}
