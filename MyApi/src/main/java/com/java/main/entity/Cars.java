package com.java.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cars {
	@Id
	@GeneratedValue
	private int id;
	private String carname;
	private String cartype;
	private int priceperkm;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	public int getPriceperkm() {
		return priceperkm;
	}

	public void setPriceperkm(int priceperkm) {
		this.priceperkm = priceperkm;
	}

	@Override
	public String toString() {
		return "Cars [id=" + id + ", carname=" + carname + ", cartype=" + cartype + ", priceperkm=" + priceperkm + "]";
	}

	public Cars(int id, String carname, String cartype, int priceperkm) {
		super();
		this.id = id;
		this.carname = carname;
		this.cartype = cartype;
		this.priceperkm = priceperkm;
	}

	public Cars() {

	}

}
