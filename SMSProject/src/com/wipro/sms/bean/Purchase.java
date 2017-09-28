package com.wipro.sms.bean;

public class Purchase {
	
	private String Purchase_ID;
	private String Product_ID;
	private String Customer_Number;
	private double Product_Price;
	private double Subtotal;
	private int Purchase_Quantity;
	
	public Purchase() {
		super();
	}
	
	public Purchase(String purchase_ID, String product_ID,
			String customer_Number, double product_Price,
			int purchase_Quantity) {
		super();
		Purchase_ID = purchase_ID;
		Product_ID = product_ID;
		Customer_Number = customer_Number;
		Product_Price = product_Price;
		Purchase_Quantity = purchase_Quantity;
	}

	public String getPurchase_ID() {
		return Purchase_ID;
	}
	public void setPurchase_ID(String purchase_ID) {
		Purchase_ID = purchase_ID;
	}
	public String getProduct_ID() {
		return Product_ID;
	}
	public void setProduct_ID(String product_ID) {
		Product_ID = product_ID;
	}
	public String getCustomer_Number() {
		return Customer_Number;
	}
	public void setCustomer_Number(String customer_Number) {
		Customer_Number = customer_Number;
	}

	public double getProduct_Price() {
		return Product_Price;
	}
	public void setProduct_Price(double product_Price) {
		Product_Price = product_Price;
	}
	public double getSubtotal() {
		return Subtotal;
	}
	public void setSubtotal(double subtotal) {
		Subtotal = subtotal;
	}
	public int getPurchase_Quantity() {
		return Purchase_Quantity;
	}
	public void setPurchase_Quantity(int purchase_Quantity) {
		Purchase_Quantity = purchase_Quantity;
	}
	
	

}
