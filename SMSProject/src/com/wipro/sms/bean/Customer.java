package com.wipro.sms.bean;

public class Customer {

	private String Customer_Number;
	private String Customer_Name;
	private String Customer_Address;
	private String Customer_Postcode;
	public Customer() {
		super();
	}
	
	public Customer(String customer_Number, String customer_Name,
			String customer_Address, String customer_Postcode) {
		super();
		Customer_Number = customer_Number;
		Customer_Name = customer_Name;
		Customer_Address = customer_Address;
		Customer_Postcode = customer_Postcode;
	}

	public String getCustomer_Number() {
		return Customer_Number;
	}
	public void setCustomer_Number(String customer_Number) {
		Customer_Number = customer_Number;
	}
	public String getCustomer_Name() {
		return Customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}
	public String getCustomer_Address() {
		return Customer_Address;
	}
	public void setCustomer_Address(String customer_Address) {
		Customer_Address = customer_Address;
	}
	public String getCustomer_Postcode() {
		return Customer_Postcode;
	}
	public void setCustomer_Postcode(String customer_Postcode) {
		Customer_Postcode = customer_Postcode;
	}
	
	
}
