package com.wipro.sms.bean;


public class Item {

	private String Product_ID; // Unique ID - Primary Key
	private String Product_Name;  // Item name
	private int Product_Quantity; // Stock levels in inventory
	private double Product_Price; // Reccomended retail price of item
	public Item() {
		super();
	}
	
	public Item(String product_Name, int product_Quantity,
			double product_Price) {
		super();
		Product_Name = product_Name;
		Product_Quantity = product_Quantity;
		Product_Price = product_Price;
	}

	public String getProduct_ID() {
		return Product_ID;
	}

	public void setProduct_ID(String product_ID) {
		Product_ID = product_ID;
	}

	public String getProduct_Name() {
		return Product_Name;
	}
	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}
	public int getProduct_Quantity() {
		return Product_Quantity;
	}
	public void setProduct_Quantity(int product_Quantity) {
		Product_Quantity = product_Quantity;
	}
	public double getProduct_Price() {
		return Product_Price;
	}
	public void setProduct_Price(double product_Price) {
		Product_Price = product_Price;
	}

	

}

