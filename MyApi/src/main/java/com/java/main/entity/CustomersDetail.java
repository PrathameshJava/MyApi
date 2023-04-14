package com.java.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CustomersDetail {
	@Id
	@GeneratedValue
	private int id;
	private String customername;
	private int customercontact;
	private String customeraddress;
	private String paymentmode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public int getCustomercontact() {
		return customercontact;
	}

	public void setCustomercontact(int customercontact) {
		this.customercontact = customercontact;
	}

	public String getCustomeraddress() {
		return customeraddress;
	}

	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	public CustomersDetail(int id, String customername, int customercontact, String customeraddress,
			String paymentmode) {
		super();
		this.id = id;
		this.customername = customername;
		this.customercontact = customercontact;
		this.customeraddress = customeraddress;
		this.paymentmode = paymentmode;
	}

	@Override
	public String toString() {
		return "CustomersDetail [id=" + id + ", customername=" + customername + ", customercontact=" + customercontact
				+ ", customeraddress=" + customeraddress + ", paymentmode=" + paymentmode + "]";
	}

	public CustomersDetail() {

	}

}